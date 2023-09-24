package com.core.calendermanagerservice.helpers;

import org.springframework.core.env.Environment;

import com.core.calendermanagerservice.configs.PropertiesConfig;

public class ConfigHelper{
    public static PropertiesConfig props(Environment env){
        PropertiesConfig obj = new PropertiesConfig();
        try{
            obj.setDIR(env.getProperty("core.DIR"));
        }catch(Exception e){}
       
        return obj;
    }
}