package pl.coderslab.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(publisherConverter());
//    }
//
//    @Bean
//    public PublisherConverter publisherConverter() {
//        return new PublisherConverter();
//    }
}
