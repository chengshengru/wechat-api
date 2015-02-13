package com.qq.weixin.api.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qq.weixin.api.model.event.*;
import org.apache.commons.lang.StringUtils;

import com.qq.weixin.api.model.BaseMessage;
import com.qq.weixin.api.model.message.ImageMessage;
import com.qq.weixin.api.model.message.LinkMessage;
import com.qq.weixin.api.model.message.LocationMessage;
import com.qq.weixin.api.model.message.TextMessage;
import com.qq.weixin.api.model.message.VideoMessage;
import com.qq.weixin.api.model.message.VoiceMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlParser {

	public static BaseMessage parse(InputStream stream) throws Exception {
		if (stream != null) {
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(stream));
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
			} catch (Exception e) {
			} finally {
				if (reader != null) {
					reader.close();
				}
				try {
					stream.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			return parse(sb.toString());
		}
		return null;
	}

	public static BaseMessage parse(String xml) throws Exception {
		BaseMessage msg = null;
		if (!StringUtils.isEmpty(xml)) {
			String msgType = getElementByTag(xml, "MsgType");
			if (!StringUtils.isEmpty(msgType)) {
				msgType=msgType.toLowerCase();
				XStream xStream = new XStream(new DomDriver());
				xStream.autodetectAnnotations(true);
				if (msgType.contains(BaseMessage.WX_MSG_TYPE_EVENT)) { // 事件推送消息
					String eventType = getElementByTag(xml, "Event");
					if (!StringUtils.isEmpty(eventType)) {
						eventType=eventType.toLowerCase();
						if (eventType
								.contains(BaseEventMessage.WX_MSG_TYPE_EVENT_SUBSCRIBE)
								|| eventType
										.contains(BaseEventMessage.WX_MSG_TYPE_EVENT_UNSUBSCRIBE)) {
							xStream.processAnnotations(EventSubscribeMessage.class);
							msg = (EventSubscribeMessage) xStream.fromXML(xml);
						} else if (eventType
								.contains(BaseEventMessage.WX_MSG_TYPE_EVENT_CLICK)) {
							xStream.processAnnotations(EventClickMessage.class);
							msg = (EventClickMessage) xStream.fromXML(xml);
						} else if (eventType
								.contains(BaseEventMessage.WX_MSG_TYPE_EVENT_LOCATION)) {
							xStream.processAnnotations(EventLocationMessage.class);
							msg = (EventLocationMessage) xStream.fromXML(xml);
						} else if (eventType
								.contains(BaseEventMessage.WX_MSG_TYPE_EVENT_SCAN)) {
							xStream.processAnnotations(EventScanMessage.class);
							msg = (EventScanMessage) xStream.fromXML(xml);
						} else if (eventType
								.contains(BaseEventMessage.WX_MSG_TYPE_EVENT_VIEW)) {
							xStream.processAnnotations(EventViewMessage.class);
							msg = (EventViewMessage) xStream.fromXML(xml);
						} else if (eventType
								.contains(BaseEventMessage.WX_MSG_TYPE_EVENT_PIC_PHOTO_OR_ALBUM)
								|| eventType
										.contains(BaseEventMessage.WX_MSG_TYPE_EVENT_PIC_SYSPHOTO)
								|| eventType
										.contains(BaseEventMessage.WX_MSG_TYPE_EVENT_PIC_WEIXIN)) {

							xStream.processAnnotations(EventPicMessage.class);
							msg = (EventPicMessage) xStream.fromXML(xml);
						}else if(eventType.contains("masssendjobfinish")){
                            xStream.processAnnotations(EventJobFinishMessage.class);
                            msg = (EventJobFinishMessage) xStream.fromXML(xml);
                        }
					}
				} else {
					if (msgType.contains(BaseMessage.WX_MSG_TYPE_TEXT)) {
						xStream.processAnnotations(TextMessage.class);
						msg = (TextMessage) xStream.fromXML(xml);
					} else if (msgType.contains(BaseMessage.WX_MSG_TYPE_VOICE)) {
						xStream.processAnnotations(VoiceMessage.class);
						msg = (VoiceMessage) xStream.fromXML(xml);
					} else if (msgType.contains(BaseMessage.WX_MSG_TYPE_IMAGE)) {
						xStream.processAnnotations(ImageMessage.class);
						msg = (ImageMessage) xStream.fromXML(xml);
					} else if (msgType.contains(BaseMessage.WX_MSG_TYPE_VIDEO)) {
						xStream.processAnnotations(VideoMessage.class);
						msg = (VideoMessage) xStream.fromXML(xml);
					} else if (msgType.contains(BaseMessage.WX_MSG_TYPE_LINK)) {
						xStream.processAnnotations(LinkMessage.class);
						msg = (LinkMessage) xStream.fromXML(xml);
					} else if (msgType
							.contains(BaseMessage.WX_MSG_TYPE_LOCATION)) {
						xStream.processAnnotations(LocationMessage.class);
						msg = (LocationMessage) xStream.fromXML(xml);
					}
				}

			}
		}
		return msg;
	}

	public static String getElementByTag(String src, String tag) {
		if (!StringUtils.isEmpty(src) && !StringUtils.isEmpty(tag)) {
			String regex = "(<" + tag + "[^>]*?((>.*?</" + tag + ">)|(/>)))";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(src);
			if (m.find()) {
				return m.group(1);
			}
		}
		return "";
	}
}
