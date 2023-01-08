import assertions.*;
import dtos.request.CreatePostDTO;
import dtos.request.CreateUserDTO;
import dtos.response.CreateUserResponseDTO;
import dtos.response.GetDeletedUserResponseDTO;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.GoRestSteps;

import java.util.Objects;

@RunWith(SerenityRunner.class)
public class GoRestApiValidation
{
    @Steps
    GoRestSteps goRestSteps;
    String userId;
    CreateUserResponseDTO createUserResponseDTO;
    @Steps
    CreateUserAssertions createUserAssertions;
    @Steps
    GetUserAssertions getUserAssertions;
    @Steps
    UpdateUserAssertions updateUserAssertions;
    @Steps
    DeleteUserAssertions deleteUserAssertions;
    GetDeletedUserResponseDTO getDeletedUserResponseDTO;
    GetDeletedUserAssertions getDeletedUserAssertions;


    @Test
    public void createUser()
    {
        //Random email generation
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        //Create user body
        CreateUserDTO createUserDTO=new CreateUserDTO();
        createUserDTO.setName("Anne");
        createUserDTO.setEmail(generatedString+"@gmail.com");
        createUserDTO.setGender("Female");
        createUserDTO.setStatus("Active");
        //Create user controller
        Response response=goRestSteps.createUser(createUserDTO);
        createUserResponseDTO=Objects.requireNonNull(response.jsonPath().getObject("",CreateUserResponseDTO.class));
        userId=createUserResponseDTO.getId();
        System.out.println(userId);
        //CreateUserAssertions
        createUserAssertions.checkThat(response).hasStatusCode(201);
        //GetUserAssertions
        response=goRestSteps.getUser(userId);
        getUserAssertions.checkThat(response).checkId(userId).hasStatusCode(200);
        //UpdateUserAssertions
        CreateUserDTO updateUserDto = new CreateUserDTO();
        updateUserDto.setName("Anne Frank");
        response=goRestSteps.updateUser(userId, updateUserDto);
        updateUserAssertions.checkThat(response).checkName("Anne Frank").hasStatusCode(200);
        //deleteUserAssertions
        response=goRestSteps.deleteUser(userId);
        deleteUserAssertions.checkThat(response).hasStatusCode(204);
        //RetrieveDeletedUser
        response=goRestSteps.getUser(userId);
        getDeletedUserResponseDTO=Objects.requireNonNull(response.jsonPath().getObject("",GetDeletedUserResponseDTO.class));
        String message=getDeletedUserResponseDTO.getMessage();
        getDeletedUserAssertions =new GetDeletedUserAssertions();
        getDeletedUserAssertions.checkThat(response).hasStatusCode(404).hasMessage(message);
    }

    @Test
    public void createPost()
    {
        //Create Post body
        CreatePostDTO createPostDTO=new CreatePostDTO();
        createPostDTO.setTitle("john wicks post");
        createPostDTO.setBody("John wicks body");
        //

    }

}
