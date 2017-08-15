package ua.goit.offline.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by User on 14.08.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan("ua.goit.offline.resources")
public class WebConfiguration extends WebMvcConfigurerAdapter {

    //add css files, images, html pages
}
