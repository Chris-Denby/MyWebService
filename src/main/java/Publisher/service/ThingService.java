package Publisher.service;


//##** BUSINESS LAYER **##


import Publisher.model.Thing;
import com.cloudmersive.client.RecognizeApi;
import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.ApiKeyAuth;
import com.cloudmersive.client.model.ImageDescriptionResponse;
import Publisher.dao.ThingJPARepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Component
public class ThingService
{
    @Autowired
    ThingJPARepository thingJPARepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public void saveThing(Thing thing)
    {
        thingJPARepository.save(thing);
    }

    public Thing getThingById(Long id)
    {
        Optional<Thing> o = thingJPARepository.findById(id);
        return o.get();
    }

    public List<Thing> getAllThings()
    {
        thingJPARepository.findAll();
        return null;
    }

    public String getPokemonTypeByName(String name)
    {
        String uri = "https://pokeapi.co/api/v2/pokemon/" + name;
        JsonNode result = webClientBuilder.build()
                .get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(response ->
                {
                    if(!response.statusCode().equals(HttpStatus.OK))
                        return Mono.empty();
                    else
                        return response.bodyToMono(JsonNode.class);
                })
                .block();

        Thing t = new Thing();
        t.setName(result.get("name").toString());
        String type = result.get("types").get(0).get("type").get("name").toString();
        t.setData(type);

        return t.toString();
    }

    public String getImageDescription(String url)
    {
        String description = null;
        //get API client with API key
        //https://api.cloudmersive.com/java-client.asp
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth Apikey = (ApiKeyAuth) defaultClient.getAuthentication("Apikey");
        Apikey.setApiKey("8308c5e3-9379-489b-bbd4-36268743ffb9");

        RecognizeApi apiInstance = new RecognizeApi();

        //get input stream of file
        InputStream in = null;
        try { in = new URL(url).openStream();}
        catch (IOException e) {
            e.printStackTrace();}

        //save file to computer
        try{Files.copy(in, Paths.get("image.jpg"));}
        catch(IOException ioException) {
            ioException.printStackTrace();}

        //classify image
        File imageFile = new File("image.jpg"); // File | Image file to perform the operation on.  Common file formats such as PNG, JPEG are supported.
        try {
            ImageDescriptionResponse result = apiInstance.recognizeDescribe(imageFile);
            System.out.println(result);
            description = result.toString();
            if(imageFile.exists())
                in.close();
                imageFile.delete();
        } catch (ApiException e) {
            System.err.println("Exception when calling RecognizeApi#recognizeDescribe");
            e.printStackTrace();
        }
        finally{
            return description;}

    }

}


