package com.qq.weixin.api.controller;

import com.qq.weixin.api.service.WechatRequestService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 微信菜单管理
 */
@RequestMapping("/wechat/menu")
@Controller
public class WechatMenuContoller {


    private WechatRequestService mRequestService = null;

    public WechatMenuContoller() {
        mRequestService = WechatRequestService.getInstance();
    }

    @RequestMapping(value = {"","/","/index"})
    public String index(){

        return "wechat/menu/index";
    }

    /**
     * 保存菜单json
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        return "";
    }

    /**
     * 同步菜单
     * @return
     */
    @RequestMapping("/sync")
    @ResponseBody
    public String sync(){
        String menu=mRequestService.getMenu();
        if(StringUtils.isNotEmpty(menu)){
            return menu;
        }
        return "{}";
    }
    /**
     * 发布菜单
     * @return
     */
    @RequestMapping("/pub")
    @ResponseBody
    public String publish(String menu){
        JSONObject result = new JSONObject();
        try {
            if(StringUtils.isNotEmpty(menu)){
                int res=mRequestService.createMenu(menu);
                if(res>0){
                    result.put("code", 1);
                    result.put("msg", "发布成功");
                }else{
                    result.put("code", 0);
                    result.put("msg", "发布失败");
                }
            }else{
                result.put("code", 400);
                result.put("msg", "参数不完整");
            }
        } catch (Exception e) {
            result.put("code", -1);
            result.put("msg", "服务器内部错误");
        }

        return result.toString();
    }
}
