/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackoverflow.jersey.hibernate;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author PaulSamsotha
 */
@ApplicationPath("/api")
public class AppConfig extends ResourceConfig {
    
    public AppConfig() {
        packages("com.stackoverflow.jersey.hibernate");
        
        register(new AbstractBinder(){
            @Override
            protected void configure() {
                bindFactory(SFFactory.class).to(Session.class).in(RequestScoped.class);
                bindFactory(SessionFactoryFactory.class).to(SessionFactory.class).in(Singleton.class);
                bind(DefaultMessageRepository.class).to(MessageRepository.class).in(Singleton.class);
            }
        });
    }
}
