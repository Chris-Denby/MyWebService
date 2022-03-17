package com.example.MyWebService.service;


//##** BUSINESS LAYER **##


import com.example.MyWebService.api.ThingController;
import com.example.MyWebService.dao.ThingDAO;
import com.example.MyWebService.model.Thing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ThingService
{

    @Autowired
    ThingDAO thingDAO;
    @Autowired
    ThingController thingController;

    public Thing saveThing(Thing thing)
    {
        return thingDAO.addThing(thing);
    }

    public Thing getThingById(int id)
    {
        return thingDAO.getThingById(id);
    }

    public List<Thing> getAllThings()
    {
        return thingDAO.getAllThings();
    }




}
