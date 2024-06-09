package com.funds4good.Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/Resources/", "classpath:/Resources/", "classpath:/target/classes/static/Resources/",
            "classpath:/static/", "classpath:/public/", "file:///"+ System.getProperty("user.dir") + "/target/classes/static/Resources" };
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/file/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://funds4good.pranavbisaria.tech", "https://funds4-good-web-app-code-x24.vercel.app", "http://localhost:3000", "http://localhost:3000/*", "https://localhost:3000/")
                .allowedOriginPatterns("*/localhost:3000/*")
                .allowedMethods("GET", "POST", "OPTIONS")
                .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept")
                .allowCredentials(true)
                .maxAge(1728000);
    }
}