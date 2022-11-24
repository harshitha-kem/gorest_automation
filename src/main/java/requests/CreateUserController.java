package requests;

import dtos.request.CreateUserDTO;
import groovy.transform.Final;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUserController {
    private final String BASE_URI="https://gorest.co.in/";
    private final String CREATE_USER_ENDPOINT="public/v2/users";
    private final String GET_USER_ENDPOINT="public/v2/users/{userId}";
    public Response createUser(CreateUserDTO createUserDTO)
    {
        RequestSpecification createUserHeaderRequest=new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader("Authorization","Bearer 256179d91c246b38b7d5d53cf6612d4c4ac27cdb8b77d1ffd8235764f0a3cbad")
                .setContentType(ContentType.JSON)
                .build();
        RequestSpecification createUserRequest= given()
                .log().all()
                .spec(createUserHeaderRequest)
                .body(createUserDTO);
        Response createUserResponse=createUserRequest
                .when()
                .log().all()
                .relaxedHTTPSValidation()
                .post(CREATE_USER_ENDPOINT);
        return createUserResponse;
    }
    public Response getUser(String userId)
    {
        RequestSpecification getUserHeaderRequest=new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader("Authorization","Bearer 256179d91c246b38b7d5d53cf6612d4c4ac27cdb8b77d1ffd8235764f0a3cbad")
                .setContentType(ContentType.JSON)
                .build();
        RequestSpecification getuserRequest=given()
                .log().all()
                .pathParam("userId",userId)
                .spec(getUserHeaderRequest);
        Response getUserResponse=getuserRequest
                .when()
                .log().all()
                .relaxedHTTPSValidation()
                .get(GET_USER_ENDPOINT);
        return  getUserResponse;
    }
    public Response updateUser(String userId,CreateUserDTO createUserDTO)
    {
        RequestSpecification updateUserHeaderRequest=new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader("Authorization","Bearer 256179d91c246b38b7d5d53cf6612d4c4ac27cdb8b77d1ffd8235764f0a3cbad")
                .setContentType(ContentType.JSON)
                .build();
        RequestSpecification updateUserRequest=given()
                .log().all()
                .pathParam("userId",userId)
                .body(createUserDTO)
                .spec(updateUserHeaderRequest);
        Response updateUserResponse=updateUserRequest
                .when()
                .log().all()
                .relaxedHTTPSValidation()
                .put(GET_USER_ENDPOINT);
        return  updateUserResponse;
    }
    public Response deleteUser(String userId)
    {
        RequestSpecification deleteUserRequestHeader=new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader("Authorization","Bearer 256179d91c246b38b7d5d53cf6612d4c4ac27cdb8b77d1ffd8235764f0a3cbad")
                .setContentType(ContentType.JSON)
                .build();
        RequestSpecification deleteUserRequest=given()
                .log().all()
                .pathParam("userId",userId)
                .spec(deleteUserRequestHeader);
        Response deleteUserResponse=deleteUserRequest
                .log().all()
                .relaxedHTTPSValidation()
                .delete(GET_USER_ENDPOINT);
        return deleteUserResponse;
    }
}
