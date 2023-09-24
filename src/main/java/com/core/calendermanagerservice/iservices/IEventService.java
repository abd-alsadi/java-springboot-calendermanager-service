package com.core.calendermanagerservice.iservices;

import java.util.List;

import com.core.calendermanagerservice.models.*;
import com.core.calendermanagerservice.models.ui.*;

import java.util.*;



public interface IEventService {
	
	public List<EventModel> GetAll(AuthunticationModel auth);

	public EventModel Add(EventModel model,AuthunticationModel auth);
		
	public EventModel GetByID(UUID id,AuthunticationModel auth);

    public EventModel Update(UUID id,EventModel model,AuthunticationModel auth);
	
	public EventModel Delete(UUID id,AuthunticationModel auth);

}