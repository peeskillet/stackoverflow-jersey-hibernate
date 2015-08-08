/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackoverflow.jersey.hibernate;

import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author PaulSamsotha
 */
public class DefaultMessageRepository implements MessageRepository {
    
    @Inject
    private javax.inject.Provider<Session> sessionProvider;

    @Override
    public void saveMessage(Message message) {
        Session session = sessionProvider.get();
        Transaction tx = session.beginTransaction();
        try {
            session.save(message);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        }
    }

    @Override
    public List<Message> findAllMessages() {
        Session session = sessionProvider.get();
        List<Message> messages = session.createCriteria(Message.class).list();
        return messages;
    }
    
}
