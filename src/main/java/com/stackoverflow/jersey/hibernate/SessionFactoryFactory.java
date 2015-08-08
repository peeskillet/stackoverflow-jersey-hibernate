/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackoverflow.jersey.hibernate;

import org.glassfish.hk2.api.Factory;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author PaulSamsotha
 */
public class SessionFactoryFactory implements Factory<SessionFactory> {
    
    private final SessionFactory sessionFactory;
    
    public SessionFactoryFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder srBuilder = new StandardServiceRegistryBuilder();
        srBuilder.applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(srBuilder.build());
    }

    @Override
    public SessionFactory provide() {
        return sessionFactory;
    }

    @Override
    public void dispose(SessionFactory factory) {
        factory.close();
    }
}
