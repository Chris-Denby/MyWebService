package Publisher.dao;

import Publisher.model.Thing;

import java.util.List;

//@Repository("fakeDAO")
public class FakeDAO implements ThingDAO{
    @Override
    public Thing addThing(Thing thing) {
        return null;
    }

    @Override
    public Thing getThingById(int id) {
        return null;
    }

    @Override
    public List<Thing> getAllThings() {
        return null;
    }
}
