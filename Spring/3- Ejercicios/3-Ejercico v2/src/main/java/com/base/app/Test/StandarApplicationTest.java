package com.base.app.Test;

import com.base.app.StandardApplication;
import com.base.app.repo.CocheRepository;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootTest(classes = StandardApplication.class)

public class StandarApplicationTest implements ApplicationContextAware {
    //AutoWired
    private ApplicationContext context ;/*=ApplicationContextProvider.getApplicationContext();*/
    @Test
    public void Test(){

        CocheRepository r2= context.getBean(CocheRepository.class);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }
}
