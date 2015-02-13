package com.qq.weixin.api;


import com.qq.weixin.api.utils.XmlParser;
import junit.framework.TestCase;

public class XmlTest extends TestCase{

	public void testText() {
		String xml = "<xml>" + "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[this is a test]]></Content>"
				+ "<MsgId>1234567890123456</MsgId>" + "</xml>";

		try {
			System.out.println(XmlParser.parse(xml));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testImage() {
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[image]]></MsgType>"
				+ "<PicUrl><![CDATA[this is a url]]></PicUrl>"
				+ "<MediaId><![CDATA[media_id]]></MediaId>"
				+ "<MsgId>1234567890123456</MsgId>"
				+ "</xml>";

		try {
			System.out.println(XmlParser.parse(xml));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testSubscribe(){
		String xml="<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[FromUser]]></FromUserName>"
				+ "<CreateTime>123456789</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[subscribe]]></Event>"
				+ "</xml>";
		try {
			System.out.println(XmlParser.parse(xml));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testScanEvent(){
		String xml="<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[FromUser]]></FromUserName>"
				+ "<CreateTime>123456789</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[SCAN]]></Event>"
				+ "<EventKey><![CDATA[SCENE_VALUE]]></EventKey>"
				+ "<Ticket><![CDATA[TICKET]]></Ticket>"
				+ "</xml>";
		try {
			System.out.println(XmlParser.parse(xml));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testUnsubscribeScan(){
		String xml="<xml><ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[FromUser]]></FromUserName>"
				+ "<CreateTime>123456789</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[subscribe]]></Event>"
				+ "<EventKey><![CDATA[qrscene_123123]]></EventKey>"
				+ "<Ticket><![CDATA[TICKET]]></Ticket>"
				+ "</xml>";
		try {
			System.out.println(XmlParser.parse(xml));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testLocation(){
		String xml="<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>123456789</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[LOCATION]]></Event>"
				+ "<Latitude>23.137466</Latitude>"
				+ "<Longitude>113.352425</Longitude>"
				+ "<Precision>119.385040</Precision>"
				+ "</xml>";
		try {
			System.out.println(XmlParser.parse(xml));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testClick(){
		String xml="<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[FromUser]]></FromUserName>"
				+ "<CreateTime>123456789</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[CLICK]]></Event>"
				+ "<EventKey><![CDATA[EVENTKEY]]></EventKey>"
				+ "</xml>";
		try {
			System.out.println(XmlParser.parse(xml));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void testView(){
		String xml="<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[FromUser]]></FromUserName>"
				+ "<CreateTime>123456789</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[VIEW]]></Event>"
				+ "<EventKey><![CDATA[www.qq.com]]></EventKey>"
				+ "</xml>";
		try {
			System.out.println(XmlParser.parse(xml));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


    public void testJobFinish(){
        String xml="<xml>\n" +
                "<ToUserName><![CDATA[gh_3e8adccde292]]></ToUserName>\n" +
                "<FromUserName><![CDATA[oR5Gjjl_eiZoUpGozMo7dbBJ362A]]></FromUserName>\n" +
                "<CreateTime>1394524295</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[MASSSENDJOBFINISH]]></Event>\n" +
                "<MsgID>1988</MsgID>\n" +
                "<Status><![CDATA[sendsuccess]]></Status>\n" +
                "<TotalCount>100</TotalCount>\n" +
                "<FilterCount>80</FilterCount>\n" +
                "<SentCount>75</SentCount>\n" +
                "<ErrorCount>5</ErrorCount>\n" +
                "</xml>";
        try {
            System.out.println(XmlParser.parse(xml));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
