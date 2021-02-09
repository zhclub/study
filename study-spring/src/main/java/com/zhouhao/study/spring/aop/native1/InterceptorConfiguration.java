package com.zhouhao.study.spring.aop.native1;

import com.zhouhao.study.spring.aop.User;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
public class InterceptorConfiguration {

    public static final String traceExecution = "execution(* com.zhouhao.study.spring.aop.*(..))";

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        UserInterceptor interceptor = new UserInterceptor();
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(traceExecution);

        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(interceptor);
        return advisor;
    }

}
