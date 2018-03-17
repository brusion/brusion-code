package com.demo.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * @author brusion
 * @date 2018/3/17
 */
public class AssessFilter extends ZuulFilter {

    Logger logger = Logger.getLogger(getClass().toString());


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
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info(String.format(" %s request to %s", request.getMethod(),request.getRequestURL().toString()));

        Object token = request.getParameter("Token");
        if (token == null){
            logger.warning("no  token  data ");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            return null;
        }
        logger.info("assess token ok");
        return null;
    }
}
