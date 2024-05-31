package com.example.demo.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    // CorsMapping will be done
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*/**")
                .allowedHeaders("*")
                .allowedOrigins("https://localhost:4200","http://localhost:4200")
                .allowedMethods("GET","POST","PUT","PATCH","DELETE");
    }

    // it represents app.UseStaticFiles()
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // "/images/products/**" URL'sini "classpath:/static/images/products/" klasörüne yönlendir
        registry.addResourceHandler("/*/images/products/**")
                .addResourceLocations("classpath:/static/images/products/**");
    }
}





















