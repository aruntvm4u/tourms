package com.tourms.config;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.util.Locale;
/**
 * Created by aruntvm4u on 2/14/2016.
 */

@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = {"com.tourms"}
//        ,includeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.leaves.app.config.*")}
)
//@Import({HibernateConfig.class, SecurityConfig.class})
public class ApplicationConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//        registry.addResourceHandler("/*.xhtml").addResourceLocations("/WEB-INF/pages/");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index");
        super.addViewControllers(registry);
    }
    //    @Bean
//    public InternalResourceViewResolver viewResolver(){
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setSuffix(".jsp");
//        viewResolver.setPrefix("/WEB-INF/views/jsp/");
//        viewResolver.setOrder(2);
//        return viewResolver;
//    }

    @Bean
    public UrlBasedViewResolver faceletsViewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(org.springframework.faces.mvc.JsfView.class);
        viewResolver.setPrefix("/WEB-INF/pages/views/");
        viewResolver.setSuffix(".xhtml");
//        viewResolver.setOrder(1);
        return viewResolver;
    }

    @Bean
    public SimpleControllerHandlerAdapter simpleControllerHandlerAdapter() {
        return  new SimpleControllerHandlerAdapter();

    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return  messageSource;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    @Bean
    public LocaleResolver localResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(Locale.ENGLISH);
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

}
