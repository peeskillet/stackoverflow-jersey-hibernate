/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackoverflow.jersey.hibernate;

import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PaulSamsotha
 */
public class HibernateInjectionTest extends JerseyTest {
    
    @Override
    public Application configure() {
        return new AppConfig();
    }
    
    @Test
    public void doTest() {
        Response response = target("messages").request().post(Entity.text("noop"));
        Message message1 = response.readEntity(Message.class);
        assertEquals("Message #1", message1.getContent());
        assertEquals(1, message1.getId());
        
        response = target("messages").request().post(Entity.text("noop"));
        Message message2 = response.readEntity(Message.class);
        assertEquals("Message #2", message2.getContent());
        assertEquals(2, message2.getId());
        
        response = target("messages").request().get();
        List<Message> messages = response.readEntity(new GenericType<List<Message>>(){});
        assertEquals(2, messages.size());
    }
}
