package com.core.calendermanagerservice.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import java.util.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.core.calendermanagerservice.constants.ModConstant;
import com.core.calendermanagerservice.helpers.AuthHelper;
import com.core.calendermanagerservice.models.*;
import com.core.calendermanagerservice.models.ui.*;
import com.core.calendermanagerservice.responses.DataResponse;
import com.core.calendermanagerservice.responses.FilterDataResponse;
import com.core.calendermanagerservice.services.*;

import org.springframework.core.io.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/Event")
@RequiredArgsConstructor
public class EventController{

    @Autowired
    private EventService service;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/GetAll")
    public ResponseEntity<DataResponse> GetAll(Authentication auth){
        DataResponse response=new DataResponse();
		try{
            AuthunticationModel authModel = AuthHelper.getAuthunticationUser(auth);
			List<EventModel> data= service.GetAll(authModel);
			response = new DataResponse(null, data, ModConstant.StatusCode.SUCCESS);
		}catch(Exception e){
			response = new DataResponse(e.getMessage(), null, ModConstant.StatusCode.ERROR);
			logger.info(ModConstant.NOT_SUCCESS_TAG);
		}
        return new ResponseEntity(response, HttpStatus.OK);
    }

   
    @GetMapping("/GetByID/{id}")
    public ResponseEntity<DataResponse> GetByID(  @PathVariable("id") UUID id,Authentication auth){
        DataResponse response=new DataResponse();
        try{
            AuthunticationModel authModel = AuthHelper.getAuthunticationUser(auth);
            EventModel data= service.GetByID(id,authModel);
             response = new DataResponse(null, data, ModConstant.StatusCode.SUCCESS);
        }catch(Exception e){
             response = new DataResponse(e.getMessage(), null, ModConstant.StatusCode.ERROR);
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PostMapping("/Add")
     public ResponseEntity<DataResponse> Add( @RequestBody EventModel object,Authentication auth){
         DataResponse response=new DataResponse();
         try{
            AuthunticationModel authModel = AuthHelper.getAuthunticationUser(auth);
            EventModel data= service.Add(object,authModel);
             response = new DataResponse(null, data, ModConstant.StatusCode.SUCCESS);
         }catch(Exception e){
             response = new DataResponse(e.getMessage(), null, ModConstant.StatusCode.ERROR);
         }
         return new ResponseEntity(response, HttpStatus.OK);
    }
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<DataResponse> Delete( @PathVariable("id") UUID id,Authentication auth){
        DataResponse response=new DataResponse();
        try{
            AuthunticationModel authModel = AuthHelper.getAuthunticationUser(auth);
            EventModel data= service.Delete(id,authModel);
            response = new DataResponse(null, data, ModConstant.StatusCode.SUCCESS);
        }catch(Exception e){
           response = new DataResponse(e.getMessage(), null, ModConstant.StatusCode.ERROR);
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PutMapping("/Update/{id}")
    public ResponseEntity<DataResponse> Update(  @PathVariable("id") UUID id,  @RequestBody EventModel object,Authentication auth){
        DataResponse response=new DataResponse();
       try{
        AuthunticationModel authModel = AuthHelper.getAuthunticationUser(auth);
        EventModel data= service.Update(id,object,authModel);
            response = new DataResponse(null, data, ModConstant.StatusCode.SUCCESS);
       }catch(Exception e){
            response = new DataResponse(e.getMessage(), null, ModConstant.StatusCode.ERROR);
       }
       return new ResponseEntity(response, HttpStatus.OK);
    }

   
}