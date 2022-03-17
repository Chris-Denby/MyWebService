package com.example.MyWebService.api;

import com.example.MyWebService.model.Thing;
import com.example.MyWebService.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThingController {

    @Autowired
    ThingService thingService;

    @PostMapping("/things")
    public void createThing(@RequestBody Thing thing)
    {
        thingService.saveThing(thing);
    }

    @GetMapping("/things/{id}")
    public Thing getThing(@PathVariable int id)
    {
        return thingService.getThingById(id);
    }

    @GetMapping("/things")
    public List<Thing> getAllThings()
    {
        return thingService.getAllThings();
    }



}
