package org.vibioh.config;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;
import com.mangofactory.swagger.paths.SwaggerPathProvider;
 
public class ApiPathProvider extends SwaggerPathProvider {
    private SwaggerPathProvider defaultSwaggerPathProvider;
    
    @Autowired
    private ServletContext servletContext;
 
    private String basePath;
 
    public ApiPathProvider(final String basePath, final SwaggerPathProvider defaultSwaggerPathProvider) {
        this.basePath = basePath;
        this.defaultSwaggerPathProvider = defaultSwaggerPathProvider;
    }
 
    @Override
    public String getApiResourcePrefix() {
        return defaultSwaggerPathProvider.getApiResourcePrefix();
    }
 
    @Override
    protected String applicationPath() {
        return UriComponentsBuilder
                .fromHttpUrl(basePath)
                .path(servletContext.getContextPath())
                .build()
                .toString();
    }

    @Override
    protected String getDocumentationPath() {
        return UriComponentsBuilder
                .fromHttpUrl(applicationPath())
                .pathSegment("api-docs/")
                .build()
                .toString();
    }
}