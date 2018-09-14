package edu.konrad.digiturnotest.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author lpajaro
 */
public class DigiturnoInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { DigiturnoSecurityConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {DigiturnoConfiguration.class};
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
        
}
