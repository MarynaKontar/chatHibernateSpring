package ua.goit.offline.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by User on 14.08.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = {"ua.goit.offline.resources", "ua.goit.offline.controllers"})
public class WebConfiguration extends WebMvcConfigurerAdapter {

    //add css files, images, html pages

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // mean we will work with JPS
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsps/");
        resolver.setSuffix(".jsp");
        // Give me view name 'products' -> JstlView(/WEB-INF/jps/ + products + .jsp)
        return resolver;
    }


    public void addViewController(ViewControllerRegistry viewControllerRegistry){
        viewControllerRegistry.addViewController("/registration").setViewName("registration");
    }
}
