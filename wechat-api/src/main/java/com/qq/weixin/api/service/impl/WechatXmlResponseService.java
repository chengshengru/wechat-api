package com.qq.weixin.api.service.impl;

import com.qq.weixin.api.config.ConfigManager;
import com.qq.weixin.api.model.BaseMessage;
import com.qq.weixin.api.model.WechatResponse;
import com.qq.weixin.api.service.IWechatResponseService;
import com.qq.weixin.api.utils.XmlParser;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User : developer
 * Date : 2015/4/28
 * Version : 1.0.1
 */
public class WechatXmlResponseService implements IWechatResponseService {

    private String mTemplateDir= ConfigManager.getInstance().getResponseTemplateDir();

    private static final Logger log=Logger.getLogger(WechatXmlResponseService.class);

    private static ConcurrentHashMap<String,BaseMessage> mCacheMap=new ConcurrentHashMap<String, BaseMessage>();

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

    public void clearMessageByKey(String key) {
        if(StringUtils.isNotEmpty(key)&&mCacheMap.containsKey(key)){
            mCacheMap.remove(key);
            log.info("Remove Cache Key is:(" + key + ")");
        }
    }

    public WechatResponse getResponseByKey(String key) {
        return null;
    }

    public List<WechatResponse> getAllResponse(int page, int pageSize) {
        return null;
    }

    public Integer addWechatResponse(WechatResponse res) {
        return null;
    }

    public Integer updateWechatResponse(WechatResponse res) {
        return null;
    }
}
