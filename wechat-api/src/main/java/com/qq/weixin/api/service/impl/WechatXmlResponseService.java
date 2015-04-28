package com.qq.weixin.api.service.impl;

import com.qq.weixin.api.config.ConfigManager;
import com.qq.weixin.api.model.BaseMessage;
import com.qq.weixin.api.service.WechatResponseService;
import com.qq.weixin.api.utils.XmlParser;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User : developer
 * Date : 2015/4/28
 * Version : 1.0.1
 */
public class WechatXmlResponseService implements WechatResponseService{

    private String mTemplateDir= ConfigManager.getInstance().getResponseTemplateDir();

    private static final Logger log=Logger.getLogger(WechatXmlResponseService.class);

    private static ConcurrentHashMap<String,BaseMessage> mCacheMap=new ConcurrentHashMap<String, BaseMessage>();

    @Override
    public BaseMessage getMessageByKey(String key) {
        BaseMessage msg=null;
        if(StringUtils.isNotEmpty(key)){
            msg=mCacheMap.get(key);
            if(msg==null){
                File file=new File(mTemplateDir,key+".xml");
                if(file.exists()){
                    try {
                        msg=XmlParser.parse(new FileInputStream(file));
                        if(msg!=null){
                            mCacheMap.put(key,msg);
                        }
                        return msg;
                    }catch (Exception e){
                        log.error("Parse Xml File ("+key+".xml) Error!",e);
                    }
                }else{
                    log.info("Cannot Find  Xml File (" + key + ".xml)!");
                }
            }
        }
        return msg;
    }

    @Override
    public void clearMessageByKey(String key) {
        if(StringUtils.isNotEmpty(key)&&mCacheMap.containsKey(key)){
            mCacheMap.remove(key);
            log.info("Remove Cache Key is:(" + key + ")");
        }
    }
}
