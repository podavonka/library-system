package cz.cvut.fel.sin.library.service.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class PublishingHouseServiceInterceptor implements HandlerInterceptor {

    private StopWatch watch;

    @Override
    public boolean preHandle
            (HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        watch = new StopWatch();
        watch.start();
        log.info("PublishingHouse service pre handle method is called");
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        log.info("PublishingHouse service post handle method is called");
        watch.stop();
    }
    @Override
    public void afterCompletion
            (HttpServletRequest request, HttpServletResponse response, Object
                    handler, Exception exception) throws Exception {

        log.info("Request and Response is completed in " + watch.getTotalTimeMillis() + " ms\n");
    }
}
