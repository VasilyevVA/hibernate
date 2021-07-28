package ru.vasilyevVA.homeWorks.lesson6;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
@ComponentScan("ru.vasilyevVA")
public class SpringConfig {

    @Bean
    @Scope("singleton")
    public SessionFactory sessionFactoryBean(){
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }


}
