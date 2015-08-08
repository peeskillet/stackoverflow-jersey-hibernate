/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackoverflow.jersey.hibernate;

import javax.inject.Inject;
import org.glassfish.hk2.api.Factory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author PaulSamsotha
 */
public class SFFactory implements Factory<Session> {
    
    private final SessionFactory sessionFactory;
    
    @Inject
    public SFFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Session provide() {
        return sessionFactory.openSession();
    }

    @Override
    public void dispose(Session session) {
        if (session.isOpen()) {
            session.close();
        }
    }
}
