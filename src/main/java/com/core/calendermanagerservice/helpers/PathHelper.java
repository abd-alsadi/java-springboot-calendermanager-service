package com.core.calendermanagerservice.helpers;

import com.core.calendermanagerservice.models.*;
public class PathHelper {
    public static String getPathDir(EventModel file){
        String path  = "";
        if(file.getOwner()!=null && !file.getOwner().equals(""))
        path+=file.getOwner();

        path+=file.getId();
        return path;
    }
}
