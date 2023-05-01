package filestest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.AnimalData;

import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonAnimalTest() throws  Exception{
        try(InputStream is = getClass().getClassLoader().getResourceAsStream("pet.json");
            InputStreamReader isr = new InputStreamReader(is)
        ){
            AnimalData animalData = objectMapper.readValue(isr,AnimalData.class);
            Assertions.assertEquals("running", animalData.getHobbies().get(0));
            Assertions.assertEquals("milk", animalData.getMeal().getEvening());
        }
    }
}
