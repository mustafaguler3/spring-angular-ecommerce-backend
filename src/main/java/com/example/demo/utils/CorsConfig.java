package com.example.demo.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    // CorsMapping will be done

    // it represents app.UseStaticFiles()
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // "/images/products/**" URL'sini "classpath:/static/images/products/" klasörüne yönlendir
        registry.addResourceHandler("/images/products/**")
                .addResourceLocations("classpath:/static/images/products/**");
    }
}





















