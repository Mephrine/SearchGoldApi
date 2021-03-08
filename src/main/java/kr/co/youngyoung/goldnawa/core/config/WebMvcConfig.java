package kr.co.youngyoung.goldnawa.core.config;

import kr.co.youngyoung.goldnawa.core.handdler.ApiVersionRequestMappingHandlerMapping;
import kr.co.youngyoung.goldnawa.core.interceptor.ApiInterceptor;
import kr.co.youngyoung.goldnawa.core.interceptor.BaseInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    BaseInterceptor baseInterceptor;
    @Autowired
    ApiInterceptor apiInterceptor;

    /**
     * 인터셉터 추가
     **/    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor).addPathPatterns("/*").excludePathPatterns("/v*/api/**");
        registry.addInterceptor(apiInterceptor).addPathPatterns("/v*/api/**");
    }

    /**
     * API 버전 리퀘스트매핑 핸들러매핑
     **/
    @Bean
    public WebMvcRegistrations webMvcRegistrations() {
        return new WebMvcRegistrations() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return new ApiVersionRequestMappingHandlerMapping("v");
            }
        };
    }
}
