package kr.co.youngyoung.goldnawa.core.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * API 인터셉터
 * 권한처리 등을 처리함
 *
 **/
@Component
public class ApiInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${api.key}")
    private String SERVER_API_KEY;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("ApiInterceptor preHandle {}, {}",getClass(), request.getRequestURL());

        String clientApiKey = request.getHeader("api-key");

        if( SERVER_API_KEY.equals(clientApiKey) ) {

        }else{
            response.sendError(401, "Authorization not authenticated");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("ApiInterceptor postHandle "+getClass());

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("ApiInterceptor afterCompletion "+getClass());
    }
}
