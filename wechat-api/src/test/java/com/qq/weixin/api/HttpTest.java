package com.qq.weixin.api;

import com.qq.weixin.api.model.WechatGroup;
import com.qq.weixin.api.network.WechatHttpUtils;

import com.qq.weixin.api.service.WechatRequestService;
import junit.framework.TestCase;

import java.io.*;

public class HttpTest extends TestCase {

	
	
	public void test(){
        try {
            File file=new File("C:\\Users\\程胜儒\\Desktop\\jingyou_wechat_user_group.sql");

            BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String line=null;
            WechatRequestService service=WechatRequestService.getInstance();
            String name=null;
            while((line=reader.readLine())!=null){
                name=line.split(",")[2].trim();

                WechatGroup group=service.createWechatGroup(name);


                System.out.println( String.format("INSERT INTO `jingyou_wechat_user_group` (WECHAT_ID,WECHAT_GROUP_NAME) VALUES ('%s', '%s');",group.getId()+"",group.getName()));
            }
            reader.close();

        }catch (Exception e){

        }
        //WechatRequestService service=WechatRequestService.getInstance();



        //service.createWechatGroup();
	}
}
