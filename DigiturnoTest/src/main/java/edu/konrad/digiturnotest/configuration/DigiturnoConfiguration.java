
package edu.konrad.digiturnotest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author lpajaro
 */
@EnableWebMvc
@Configuration
@ComponentScan({"edu.konrad.digiturnotest.configuration",
                "edu.konrad.digiturnotest.controller",
                "edu.konrad.digiturnotest.dao",
                "edu.konrad.digiturnotest.model"})
public class DigiturnoConfiguration extends WebMvcConfigurerAdapter{
    
    
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
 
        return viewResolver;
    }
    
}
