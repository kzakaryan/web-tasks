package com.bobocode;

import com.bobocode.annotation.Trimmed;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * This processor looks for beans where method parameters are marked with {@link Trimmed} annotation,
 * creates a proxy of them, and trims all {@link String} arguments marked with {@link Trimmed}.
 */
public class TrimmedAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        // Not necessary to modify this method for our functionality.
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        // If the bean has methods with parameters annotated with @Trimmed, we will create a proxy
        return Enhancer.create(bean.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                // Iterate through method parameters and trim all strings annotated with @Trimmed
                if (args != null) {
                    for (int i = 0; i < args.length; i++) {
                        if (args[i] instanceof String && method.getParameters()[i].isAnnotationPresent(Trimmed.class)) {
                            args[i] = ((String) args[i]).trim(); // Trim the string
                        }
                    }
                }
                // Call the original method
                return proxy.invokeSuper(obj, args);
            }
        });
    }
}
