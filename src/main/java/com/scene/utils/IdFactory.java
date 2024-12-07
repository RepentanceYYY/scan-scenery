package com.scene.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IdFactory {
    public String getUUID(){
        return UUID.randomUUID().toString();
    }
}
