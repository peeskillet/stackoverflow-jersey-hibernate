/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackoverflow.jersey.hibernate;

import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author PaulSamsotha
 */
@Path("/messages")
public class MessageResource {
    
    static final AtomicInteger messageCount = new AtomicInteger();
    
    @Inject
    private MessageRepository messageRepo;
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response post() {
        Message message = new Message();
        message.setContent("Message #" + messageCount.incrementAndGet());
        messageRepo.saveMessage(message);
        return Response.ok(message).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(messageRepo.findAllMessages()).build();
    }
}
