package org.codenova.groupware.config;


import org.codenova.groupware.Interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 패턴 표기는 ant 표기를 따르고 있고,
        // 여러 패턴을 동시에 지정하고 싶으면 , 로 여러개 지정하면 된다.
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/api/private/**", "/api/board/**",
                        "/api/note/**", "/api/chat/**");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 패턴 표기는 ant 표기를 따르고 있고,
//        // 여러 패턴을 동시에 지정하고 싶으면 , 로 여러개 지정하면 된다.
//        // registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/**", "/api/board/**","/api/note/**");
//    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedOrigins("*")
//                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS");
//    }
}
