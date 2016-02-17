package com.tourms.config;
import com.sun.faces.config.ConfigureListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.faces.webapp.FacesServlet;
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
/**
 * Created by aruntvm4u on 2/10/2016.
 */
public class ApplicationContextInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ SecurityConfig.class, ApplicationConfig.class};
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[0];
        return null;
    }
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/tourms/*" };
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] { new CharacterEncodingFilter() };
    }

    @Override
    public void onStartup(ServletContext context) throws ServletException{
        /*Faces Servlet*/
        logger.info("Bootstrapping Application...");
        ServletRegistration.Dynamic facesServlet = context.addServlet("FacesDispatcherServlet", FacesServlet.class);
        facesServlet.setLoadOnStartup(1);
        facesServlet.addMapping("*.xhtml", "*.jsf", "*.faces", "/faces/*", "/", "/index.html");

        /* El Resolver */
//        ServletRegistration.Dynamic elResolver = context.addServlet("elResolver", new ELResolverInitializerService());
//        facesServlet.setLoadOnStartup(2);
        /*Context Params*/
        context.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
        context.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
        context.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
//        context.setInitParameter("javax.faces.FACELETS_LIBRARIES", "/WEB-INF/config/springsecurity.taglib.xml");
        context.addListener(ConfigureListener.class);
        logger.info("Context Initializing...");
        super.onStartup(context);
    }
}
