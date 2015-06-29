package com.qq.weixin.api.service;

import com.qq.weixin.api.model.BaseMessage;
import com.qq.weixin.api.model.WechatResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.view.XMLToolboxManager;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by chengshengru on 15-6-29.
 */
public class WechatResponseService {

    private VelocityEngine mEngine;

    private Map<String, Object> mToolbox = null;

    private static final String ROOT_DIR_PATH = System.getProperty("WebRoot");

    private String mToolboxLocation = "WEB-INF/wechat-toolbox.xml";

    private void initEngine() {
        try {
            Properties p=new Properties();
            //p.load(this.getClass().getResourceAsStream("/velocity.properties"));
            p.put("runtime.log.logsystem.class","org.apache.velocity.runtime.log.Log4JLogChute");
            p.put("runtime.log.logsystem.log4j.logger","console");
            mEngine = new VelocityEngine();
            mEngine.init(p);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @SuppressWarnings({ "deprecation", "unchecked" })
    private void initToolbox() {
        mToolbox = new HashMap<String, Object>();
        try {
            if (StringUtils.isNotEmpty(mToolboxLocation)) {
                String path = ROOT_DIR_PATH + mToolboxLocation;
                XMLToolboxManager toolbox = new XMLToolboxManager();
                toolbox.load(path);
                mToolbox = toolbox.getToolbox(mToolbox);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建Veloctity 上下文
     * @return
     */
    private VelocityContext createVelocityContext() {
        VelocityContext context = new VelocityContext();
        for (Map.Entry<String, Object> entry : this.mToolbox.entrySet()) {
            context.put(entry.getKey(), entry.getValue());
        }
        return context;
    }

    /**
     * 合并字符串模板
     *
     * @param context
     * @param template
     * @return
     */
    private String merge(VelocityContext context, String template) {
        StringWriter writer = null;
        try {
            if (StringUtils.isNotEmpty(template) && context != null) {
                writer = new StringWriter();
                // 转换输出
                mEngine.evaluate(context, writer, "", template); // 关键方法
                writer.flush();
                return writer.toString();
            }
        } catch (Exception e) {

        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e2) {
                }
            }
        }
        return template;
    }
    public  WechatResponse getResponseByKey(String key){

        return null;
    }

    /**
     * 获取所有的自动回复消息
     *
     * @param page
     * @param pageSize
     * @return
     */
    public List<WechatResponse> getAllResponse(int page, int pageSize) {
        return null;
    }

    /**
     * 添加自动回复消息
     * @param res
     * @return
     */
    public Integer addWechatResponse(WechatResponse res){
        return 0;
    }

    /**
     * 更新回复消息
     * @param res
     * @return
     */
    public Integer updateWechatResponse(WechatResponse res){
        return 0;
    }

    public String transferResponse(String key, BaseMessage msg) {
        return null;
    }
}
