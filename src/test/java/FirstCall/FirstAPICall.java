package FirstCall;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataEntity.ResponseItem;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class FirstAPICall {

    @Test
    public void getAllGamesAndResponseTime() {
        RequestSpecification requestSpec = new RequestSpecBuilder().build();
        Response response = given().spec(requestSpec).get("http://localhost:8080/app/videogames");
        System.out.println("VideogameResponse Time : " + response.getTimeIn(TimeUnit.MILLISECONDS) + " mls");
        response.then().log().body();

    }

    @Test
    public void createGameWithSerialization() {

        ResponseItem responseItem = new ResponseItem();
        responseItem.setId(11);
        responseItem.setName("FIFA 22");
        responseItem.setReviewScore(71);
        responseItem.setCategory("Simulator");
        responseItem.setRating("Mature");
        responseItem.setReleaseDate("2022-09-21");

        given().body(responseItem)
                .header("Content-Type", "application/json")
                .when()
                .post("http://localhost:8080/app/videogames")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .log().body();


    }



    @Test
    public void getByIdAndDeserialized() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ResponseItem responseItem = given()
                .header("Accept", "application/json")
                .when()
                .get("http://localhost:8080/app/videogames/9").as((Type) ResponseItem.class);
        System.out.println(responseItem.toString());
        String responseAsString = objectMapper.writeValueAsString(responseItem);
        System.out.println(responseAsString);

    }



    @Test
    public void updateGame() {
        ResponseItem responseItem = new ResponseItem();
        responseItem.setId(11);
        responseItem.setName("PES21");
        responseItem.setCategory("Sport");

        given().body(responseItem)
                .header("Content-Type", "application/json")
                .when()
                .put("http://localhost:8080/app/videogames/11")
                .then()
                .log().body();
    }
}
