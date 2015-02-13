package com.qq.weixin.api;

import java.io.Writer;

import com.qq.weixin.api.model.BaseMessage;
import com.qq.weixin.api.model.message.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * Created with IntelliJ IDEA.
 * User : developer
 * Date : 2015/2/6
 * Version : 1.0.1
 */
public abstract class WechatService {

    /**
     * 处理微信消息
     *
     * @param msg
     * @return
     */
    public String handleWechatMessage(BaseMessage msg) throws Exception {
        BaseMessage response = null;
        if (msg instanceof TextMessage) {
            response = handleWechatTextMessage((TextMessage) msg);
        } else if (msg instanceof ImageMessage) {
            response = handleWechatImageMessage((ImageMessage) msg);
        } else if (msg instanceof VoiceMessage) {
            response = handleWechatVoiceMessage((VoiceMessage) msg);
        } else if (msg instanceof VideoMessage) {
            response = handleWechatVideoMessage((VideoMessage) msg);
        } else if (msg instanceof LocationMessage) {
            response = handleWechatLocationMessage((LocationMessage) msg);
        } else if (msg instanceof LinkMessage) {
            response = handleWechatLinkMessage((LinkMessage) msg);
        }

        if (response != null) {
            return getXStream().toXML(response);
        }

        return null;
    }


    public static XStream getXStream() {
        XStream xStream = new XStream(new XppDriver() {

            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out) {
                    // 对所有xml节点的转换都增加CDATA标记
                    boolean cdata = true;

                    @Override
                    public void startNode(String name,
                                          @SuppressWarnings("rawtypes") Class clazz) {
                        super.startNode(name, clazz);
                    }

                    @Override
                    protected void writeText(QuickWriter writer, String text) {
                        if (cdata) {
                            writer.write("<![CDATA[");
                            writer.write(text);
                            writer.write("]]>");
                        } else {
                            writer.write(text);
                        }
                    }
                };
            }

        });
        xStream.autodetectAnnotations(true);
        return xStream;
    }

    /**
     * 处理文本消息
     *
     * @param msg
     * @return
     * @throws Exception
     */
    public abstract BaseMessage handleWechatTextMessage(TextMessage msg) throws Exception;

    /**
     * 处理图片消息
     *
     * @param msg
     * @return
     * @throws Exception
     */
    public abstract BaseMessage handleWechatImageMessage(ImageMessage msg) throws Exception;

    /**
     * 处理语音消息
     *
     * @param msg
     * @return
     * @throws Exception
     */
    public abstract BaseMessage handleWechatVoiceMessage(VoiceMessage msg) throws Exception;

    /**
     * 处理视频消息
     *
     * @param msg
     * @return
     * @throws Exception
     */
    public abstract BaseMessage handleWechatVideoMessage(VideoMessage msg) throws Exception;

    /**
     * 处理地理位置消息
     *
     * @param msg
     * @return
     * @throws Exception
     */
    public abstract BaseMessage handleWechatLocationMessage(LocationMessage msg)
            throws Exception;

    /**
     * 处理链接消息
     *
     * @param msg
     * @return
     * @throws Exception
     */
    public abstract BaseMessage handleWechatLinkMessage(LinkMessage msg) throws Exception;


}
