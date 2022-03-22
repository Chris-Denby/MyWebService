package Publisher.dao;

import Publisher.model.Thing;

import java.util.List;

public interface ThingDAO
{

    public Thing addThing(Thing thing);

    public Thing getThingById(int id);

    public List<Thing> getAllThings();




}
