/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackoverflow.jersey.hibernate;

/**
 *
 * @author PaulSamsotha
 */
public class Message {
    
    private int id;
    
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", content=" + content + '}';
    }
}
