package com.bookIt.config;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.AbstractConfigurableTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class ThymeleafConfiguration implements WebMvcConfigurer, ApplicationContextAware {
    private static final String CHARACTER_ENCODING = "UTF-8";
    private ApplicationContext applicationContext;
    private static int resolverOrder = 1;

    @Value("${spring.config.additional-location}")
    private String configLocation;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

    @Bean
    public ViewResolver htmlViewResolver(LayoutDialect layoutDialect) {
        return createViewResolver("text/html", "*.html", layoutDialect);
    }

    @Bean
    public ViewResolver javascriptViewResolver() {
        return createViewResolver("application/javascript", "*.js", layoutDialect());
    }

    private ViewResolver createViewResolver(String type, String suffix, LayoutDialect layoutDialect) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine(layoutDialect));
        resolver.setContentType(type);
        resolver.setCharacterEncoding(CHARACTER_ENCODING);
        resolver.setViewNames(new String[]{suffix});
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(LayoutDialect layoutDialect) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addDialect(layoutDialect);
        engine.setMessageSource(messageSource());
        engine.addTemplateResolver(defaultHtmlTemplateResolver());
        engine.addTemplateResolver(defaultVueTemplateResolver());
        engine.addTemplateResolver(defaultJsTemplateResolver());
        return engine;
    }

    public ITemplateResolver defaultHtmlTemplateResolver() {
        return createTemplateResolver("classpath:templates/", TemplateMode.HTML, ".html");
    }

    public ITemplateResolver defaultVueTemplateResolver() {
        return createTemplateResolver("classpath:templates/", TemplateMode.HTML, ".vue");
    }

    public ITemplateResolver defaultJsTemplateResolver() {
        return createTemplateResolver("classpath:templates/", TemplateMode.JAVASCRIPT, ".js");
    }

    private ITemplateResolver createTemplateResolver(String path, TemplateMode mode, String suffix) {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);

        this.configureResolver(resolver, path, mode, suffix);
        return resolver;
    }

    private void configureResolver(AbstractConfigurableTemplateResolver resolver, String path, TemplateMode mode, String suffix) {
        resolver.setOrder(resolverOrder++);
        resolver.setCheckExistence(true);
        resolver.setPrefix(path);
        resolver.setCacheable(false);
        resolver.setTemplateMode(mode);
        resolver.setSuffix(suffix);
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();

        List<String> baseNames = new ArrayList<>();
        String baseName = "messages";
        String resourceLocation = configLocation + "/messages/";
        baseNames.add(String.format("file:%s", Paths.get(resourceLocation, baseName)));
        baseNames.add(String.format("classpath:%s", baseName));
        resource.setBasenames(baseNames.toArray(new String[baseNames.size()]));
        String encoding = "UTF-8";
        resource.setDefaultEncoding(encoding);
        resource.setUseCodeAsDefaultMessage(true);
        return resource;
    }
}
