package com.study.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 我走路带风
 * @since 2020/11/6 10:05
 */
//@Component
public class ParamFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = currentContext.getRequest();
        //获取参数
        String toekn = request.getParameter("token");
        if (!"123".equals(toekn)) {
            currentContext.setSendZuulResponse(false);//校验不通过，直接响应
            //返回错误提示
            currentContext.setResponseBody("user is invalid");
            currentContext.setResponseStatusCode(401);
        }else {
            //正常调用服务接口
        }
        return null;
    }
}
