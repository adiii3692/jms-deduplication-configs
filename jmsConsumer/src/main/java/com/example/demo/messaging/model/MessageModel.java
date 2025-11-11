package com.example.demo.messaging.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MessageModel {
    private UUID id;
    private String serviceName;

    // Set a UUID
    public MessageModel(){
        this.id = UUID.fromString("63703d87-b563-4e65-9e58-1e0df47b914a");
//        this.id = UUID.randomUUID();
    }

    @Override
    public String toString(){
        return "MessageModel{id=" + id + ", serviceName='" + serviceName + "'}";
    }
}
