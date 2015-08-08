/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackoverflow.jersey.hibernate;

import java.util.List;

/**
 *
 * @author PaulSamsotha
 */
public interface MessageRepository {
    
    void saveMessage(Message message);
    
    List<Message> findAllMessages();
}
