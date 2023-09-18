package cz.cvut.fel.sin.library.service.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class BookServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    BookServiceInterceptor bookServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bookServiceInterceptor);
    }
}
