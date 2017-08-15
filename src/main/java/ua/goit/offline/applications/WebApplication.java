package ua.goit.offline.applications;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ua.goit.offline.configuration.ModelConfiguration;
import ua.goit.offline.configuration.SpringSecurityConfiguration;
import ua.goit.offline.configuration.WebConfiguration;

/**
 * Created by User on 14.08.2017.
 */
public class WebApplication extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {ModelConfiguration.class, SpringSecurityConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"}; // /services/
    }
}
