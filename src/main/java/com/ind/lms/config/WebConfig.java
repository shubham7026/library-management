package com.ind.lms.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /*@Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Bean
    public BeanNameViewResolver beanNameViewResolver(){
        return new BeanNameViewResolver();
    }

    @Bean
    public View sample() {
        return new JstlView("/WEB-INF/view/sample.jsp");
    }*/

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("home");
    }
}
