import assertions.CreateUserAssertions;
import assertions.DeleteUserAssertions;
import assertions.GetUserAssertions;
import assertions.UpdateUserAssertions;
import dtos.request.CreateUserDTO;
import dtos.response.CreateUserResponseDTO;
import dtos.response.GetUserResponseDTO;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import steps.GoRestSteps;

import java.util.Objects;

public class GoRestApiValidation
{
    GoRestSteps goRestSteps;
    String userId;
    CreateUserResponseDTO createUserResponseDTO;
    GetUserResponseDTO getUserResponseDTO;
    CreateUserAssertions createUserAssertions;
    GetUserAssertions getUserAssertions;
    UpdateUserAssertions updateUserAssertions;
    DeleteUserAssertions deleteUserAssertions;

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
        goRestSteps=new GoRestSteps();
        Response response=goRestSteps.createUser(createUserDTO);
        createUserResponseDTO=Objects.requireNonNull(response.jsonPath().getObject("",CreateUserResponseDTO.class));
        userId=createUserResponseDTO.getId();
        System.out.println(userId);
        //CreateUserAssertions
        createUserAssertions=new CreateUserAssertions();
        createUserAssertions.checkThat(response).hasStatusCode(201);
        //GetUserAssertions
        response=goRestSteps.getUser(userId);
        getUserAssertions=new GetUserAssertions();
        getUserAssertions.checkThat(response).checkId(userId).hasStatusCode(200);
        //UpdateUserAssertions
        createUserDTO.setName("Anne Frank");
        response=goRestSteps.updateUser(userId,createUserDTO);
        updateUserAssertions=new UpdateUserAssertions();
        updateUserAssertions.checkThat(response).checkName("Anne Frank").hasStatusCode(200);
        //deleteUserAssertions
        response=goRestSteps.deleteUser(userId);
        deleteUserAssertions=new DeleteUserAssertions();
        deleteUserAssertions.checkThat(response).hasStatusCode(204);
        //RetrieveDeletedUser
        response=goRestSteps.getUser(userId);
        getUserAssertions=new GetUserAssertions();
        getUserAssertions.checkThat(response).hasStatusCode(404);
    }

}
