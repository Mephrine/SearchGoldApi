package kr.co.youngyoung.goldnawa.core.handdler;

import kr.co.youngyoung.goldnawa.core.annotation.ApiVersion;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.mvc.condition.*;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @apiNote API 버전을 관리해주는 핸들러
 * @author devrartes
 **/
public class ApiVersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
    private final String PREFIX;

    public ApiVersionRequestMappingHandlerMapping(String prefix) {
        this.PREFIX = prefix;
    }

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo info = super.getMappingForMethod(method, handlerType);
        if( info == null ) return null;

        ApiVersion methodAnnotation = AnnotationUtils.findAnnotation(method, ApiVersion.class);

        if( methodAnnotation != null ) {
            RequestCondition<?> methodCondition = getCustomMethodCondition(method);
            info = createApiVersionInfo(methodAnnotation, methodCondition).combine(info);
        } else {
            ApiVersion typeAnnotation = AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
            if( typeAnnotation != null) {
                RequestCondition<?> typeCondition = getCustomTypeCondition(handlerType);
                info = createApiVersionInfo(typeAnnotation, typeCondition).combine(info);
            }
        }

        return info;
    }

    private RequestMappingInfo createApiVersionInfo(ApiVersion annotation, RequestCondition<?> customCondition) {
        double[] values = annotation.value();
        String[] patterns = new String[values.length];

        for(int i = 0; i < values.length; i++) {
            //URL 패턴 빌드
            patterns[i] = PREFIX + values[i];
        }

        return RequestMappingInfo
                .paths(patterns)
                .customCondition(customCondition)
                .build();
    }
}
