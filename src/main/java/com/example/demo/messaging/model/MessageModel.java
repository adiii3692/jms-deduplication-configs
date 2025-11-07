package com.example.demo.messaging.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MessageModel {
    private UUID id;
    private String serviceName;

    public MessageModel(){
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString(){
        return "MyMessage{id=" + id + ", serviceName='" + serviceName + "'}";
    }
}
