package com.qq.weixin.api.controller;

import com.qq.weixin.api.WechatService;
import com.qq.weixin.api.model.AccessToken;
import com.qq.weixin.api.model.BaseMessage;
import com.qq.weixin.api.service.WechatRequestService;
import com.qq.weixin.api.utils.XmlParser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User : developer
 * Date : 2015/2/13
 * Version : 1.0.1
 */
@Controller
@RequestMapping("/wx")
public class WechatController {

    @Autowired
    private WechatService wechatService;


    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        String echo = request.getParameter("echostr");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(echo);
            writer.flush();
        } catch (Exception e) {
        } finally {
            if (writer!=null){
                writer.close();
            }
        }
    }


    @RequestMapping(value = "/api", method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        PrintWriter writer = null;
        try {
            InputStream ins=request.getInputStream();
            BaseMessage msg=XmlParser.parse(ins);
            if(msg!=null){
                String result=wechatService.handleWechatMessage(msg);
                if (!StringUtils.isEmpty(result)) {
                    writer = response.getWriter();
                    writer.write(result);
                    writer.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(writer!=null){
                writer.close();
            }
        }
    }


    @RequestMapping(value = "/oauth2")
    public String oauth2(@RequestParam(value = "code", required = false) String code,
                        @RequestParam(value = "state", required = false) String state,HttpServletResponse response){

        if (StringUtils.isNotEmpty(code)){
            AccessToken token=null;
            try {
                token=WechatRequestService.getInstance().getOAuthToken(code);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (token!=null){
                String openId=token.getOpenId();

            }
        }
        return "";
    }


}
