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
    public MessageModel(UUID uuid, String serviceName){
        if (uuid == null){
            this.id = UUID.randomUUID();
        }else{
            this.id = uuid;
        }
        this.serviceName = serviceName;
    }

    @Override
    public String toString(){
        return "MessageModel{id=" + id + ", serviceName='" + serviceName + "'}";
    }
}
