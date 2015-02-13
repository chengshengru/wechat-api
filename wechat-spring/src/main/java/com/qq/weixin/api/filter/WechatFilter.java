package com.qq.weixin.api.filter;

import com.qq.weixin.api.service.WechatRequestService;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * 微信请求Filter
 * User : developer
 * Date : 2015/2/13
 * Version : 1.0.1
 */
public class WechatFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String timestamp=request.getParameter("timestamp");
        String nonce=request.getParameter("nonce");
        String signature = request.getParameter("signature");
        boolean isSuccess= WechatRequestService.getInstance().checkWechatSign(signature,timestamp,nonce);
        if(isSuccess){
            chain.doFilter(request,response);
        }else{
            PrintWriter writer=response.getWriter();
            String result="{\"code\":-1,\"msg\":\"Invalidate Wechat Request!\"}";
            writer.write(result);
            writer.flush();
            writer.close();
        }
    }

    @Override
    public void destroy() {

    }
}
