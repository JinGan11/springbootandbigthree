package com.example.demo.config;

import com.example.demo.filter.MyFilter;
import com.example.demo.interrupt.MyInterceptor;
import com.example.demo.listener.MyHttpSessionListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description: 配置类
 *
 * @author gan.jin@ucarinc.com
 * @version 1.0
 * @Date 2019/10/28 11:37
 */
@Configuration
public class MywebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/zxc/foo").setViewName("foo");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/asd/**");
    }
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    @Bean
//    public FilterRegistrationBean filterRegist() {
//        FilterRegistrationBean frBean = new FilterRegistrationBean();
//        frBean.setFilter(new MyFilter());
//        frBean.addUrlPatterns("/*");
//        System.out.println("filter");
//        return frBean;
//    }
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    @Bean
//    public ServletListenerRegistrationBean listenerRegist() {
//        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
//        srb.setListener(new MyHttpSessionListener());
//        System.out.println("listener");
//        return srb;
//    }
}
