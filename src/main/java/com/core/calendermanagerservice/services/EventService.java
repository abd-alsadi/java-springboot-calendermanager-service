package com.core.calendermanagerservice.services;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import javax.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import java.time.LocalDate ;

import com.core.calendermanagerservice.iservices.IEventService;
import com.core.calendermanagerservice.models.*;
import com.core.calendermanagerservice.models.ui.AuthunticationModel;
import com.core.calendermanagerservice.repositories.*;


import org.springframework.core.env.Environment;

@Service
public class EventService implements IEventService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private EventRepository repo;

    @Autowired
    private EntityManager emf;

    @Autowired
    Environment env;


    @Override
    public List<EventModel> GetAll(AuthunticationModel auth){
        try{
            return repo.findByOwner(auth.getUsername());
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public EventModel Add(EventModel model, AuthunticationModel auth){
        try{

            String newID="";
            if (model.getId()==null){
                model.setId(UUID.randomUUID()); 
            }
            

            model.setFlag(0);
            LocalDate localDate = LocalDate.now();
            String currentDate = localDate.toString();
            model.setCreatedAt(currentDate);
            model.setUpdatedAt(currentDate);
            model.setOwner(auth.getUsername());

            EventModel data= repo.save(model);
            return data;
         }catch(Exception e){
            return null;
        }
    }
    


    @Override
    public EventModel Delete(UUID id, AuthunticationModel auth) {
        try{
            EventModel model =GetByID(id, auth);
            if(model==null)
            return null;
            repo.deleteById(id);
            return model;
        }catch(Exception e){
            return null;
        }
    }

   
    @Override
    public EventModel GetByID(UUID id, AuthunticationModel auth) {
        try{
            EventModel data= repo.findById(id).orElse(null);
            return data;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public EventModel Update(UUID id, EventModel object, AuthunticationModel auth) {
        try{
            object.setId(id);
            LocalDate localDate = LocalDate.now();
            String currentDate = localDate.toString();
            object.setUpdatedAt(currentDate);
            EventModel data= repo.save(object);
            return data;
        }catch(Exception e){
            return null;
        }
    }
 
}
