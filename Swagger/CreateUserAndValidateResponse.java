package Swagger;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateUserAndValidateResponse {
    @Test
    public void creatingAuserAndValidatingStatusCode(){
        UserDetailsOfSwagger user=new UserDetailsOfSwagger();
        user.setUsername("tester1");
        user.setFirstName("tester");
        user.setLastName("t");
        user.setEmail("test123@gmail.com");
        user.setPassword("123test");
        user.setPhone("8374572940");
        user.setUserStatus(1);
        Response response=
                given().contentType(ContentType.JSON).
                        body(user).
                        log().
                        body().
                        when().post("https://petstore.swagger.io/v2/user").
                        then().assertThat().statusCode(200).extract().response();
        System.out.println("Response:"+response.asPrettyString());


    }
    @Test
    public void verifyMultipleUsersCreation() {
        List<MultipleUsers> userCreationArray = new ArrayList<>();

        MultipleUsers user1 = new MultipleUsers();
        MultipleUsers user2 = new MultipleUsers();

       user1.setId("1");
        user1.setUsername("tester2");
        user1.setFirstName("tesster");
        user1.setLastName("t1");
        user1.setEmail("tester1@gmail.com");
        user1.setPassword("test123");
        user1.setPhone("8374572940");
        user1.setUserStatus(1);

        user2.setId("2");
        user2.setUsername("tester3");
        user2.setFirstName("tester");
        user2.setLastName("t2");
        user2.setEmail("tester3@gmail.com");
        user2.setPassword("test123");
        user2.setPhone("8374572940");
        user2.setUserStatus(1);

        userCreationArray.add(user1);
        userCreationArray.add(user2);

        Response response=
                given().contentType(ContentType.JSON).
                        body(userCreationArray).
                        log().
                        body().
                        when().post("https://petstore.swagger.io/v2/user/createWithArray").
                        then().assertThat().statusCode(200).extract().response();
        System.out.println("Response:"+response.asPrettyString());

    }

    }


