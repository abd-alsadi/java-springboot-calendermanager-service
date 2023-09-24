package com.core.calendermanagerservice.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.calendermanagerservice.models.*;

import javax.transaction.Transactional;

import java.util.*;


@Repository
@Transactional
public interface EventRepository extends JpaRepository<EventModel,UUID>{
    List<EventModel> findByOwner(String name);
}