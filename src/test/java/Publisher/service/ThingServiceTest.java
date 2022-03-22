package Publisher.service;

import Publisher.model.Thing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThingServiceTest {

    @Test
    void itShouldSaveAThingAndReturnIt()
    {
        //given
        Thing t = new Thing("Squirtle");

        //when
        service.saveThing(t);

        //then
        //assert(id>-1);

    }

    @Test
    void itShouldGetImageDescription()
    {

        //given
        String imageUrl = "https://upload.wikimedia.org/wikipedia/en/a/a6/Pok%C3%A9mon_Pikachu_art.png";

        //when
        String description = service.getImageDescription(imageUrl);

        //then
        assertNotNull(description);

    }

    ThingService service = new ThingService();

}