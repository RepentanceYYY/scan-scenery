package com.scene.utils;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateTimeFactory {
    public Date getCurrentDate(){
        return new Date();
    }
}
