package com.pccomponentes.practice.config;

import com.pccomponentes.practice.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/api/opinion/*")
                .addPathPatterns("/api/basket/*")
                .addPathPatterns("/api/pedido/*")
                .addPathPatterns("/api/client/*")
                .addPathPatterns("/api/basket/*");
    }
}
