package Publisher.api;

import Publisher.model.Thing;
import Publisher.service.ThingService;
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
    public Thing getThing(@PathVariable Long id)
    {
        return thingService.getThingById(id);
    }

    @GetMapping("/things")
    public List<Thing> getAllThings()
    {
        return thingService.getAllThings();
    }

    @GetMapping("/things/test")
    public String test()
    {
        return "test method heard you";
    }

    @GetMapping("/pokemon/{name}")
    public String testClient(@PathVariable String name)
    {
        return thingService.getPokemonTypeByName(name);
    }

    @GetMapping("/thing/describe")
    public String describeImage(@PathVariable String url)
    {
        return thingService.getImageDescription(url);
    }



}
