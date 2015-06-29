package com.qq.weixin.api.controller;

/**
 * Created by chengshengru on 15-6-29.
 */

import com.qq.weixin.api.model.WechatResponse;
import com.qq.weixin.api.service.WechatResponseService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 微信自动回复管理
 */
@RequestMapping("/wechat/response")
@Controller
public class WechatResponseController {

    @Autowired
    private WechatResponseService wechatResponseService;

    @RequestMapping({ "", "/" })
    public String index(Model model) {
        List<WechatResponse> list = wechatResponseService.getAllResponse(1, 50);
        model.addAttribute("resList", list);
        return "wechat/response/index";
    }

    @RequestMapping("/add")
    public String add(
            @RequestParam(value = "key", required = false) String key,
            Model model) {
        try {
            WechatResponse res = wechatResponseService.getResponseByKey(key);
            model.addAttribute("res", res);
        } catch (Exception e) {
        }
        return "wechat/response/add";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String addWechatResponse(WechatResponse res) {
        JSONObject result = new JSONObject();
        try {
            if (res != null) {
                if (StringUtils.isNotEmpty(res.getResKey())) {
                    if (res.getResId() > 0) { // 更新
                        int resCode = wechatResponseService
                                .updateWechatResponse(res);
                        if (resCode > 0) {
                            result.put("code", 1);
                            result.put("msg", "更新成功");
                        } else {
                            result.put("code", 0);
                            result.put("msg", "更新失败");
                        }
                    } else { // 新增
                        WechatResponse check = wechatResponseService
                                .getResponseByKey(res.getResKey());
                        if (check == null) {
                            int resCode = wechatResponseService
                                    .addWechatResponse(res);
                            if (resCode > 0) {
                                result.put("code", 1);
                                result.put("msg", "添加成功");
                            } else {
                                result.put("code", 0);
                                result.put("msg", "添加失败");
                            }
                        } else {
                            result.put("code", 0);
                            result.put("msg", "添加失败,该Key已被占用");
                        }
                    }
                } else {
                    result.put("code", 0);
                    result.put("msg", "参数错误");
                }
            } else {
                result.put("code", 0);
                result.put("msg", "Key不能为空");
            }
        } catch (Exception e) {
            result.put("code", -1);
            result.put("msg", "服务器错误");
        }
        return result.toString();
    }

}
