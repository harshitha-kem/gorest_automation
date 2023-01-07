package steps;

import dtos.request.CreateUserDTO;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import requests.CreateUserController;

public class GoRestSteps
{
    CreateUserController createUserController;
    @Step("Create User {0}")
    public Response createUser(CreateUserDTO createUserDTO)
    {
        CreateUserController createUserController=new CreateUserController();
        return createUserController.createUser(createUserDTO);
    }
   @Step("Get User {0}")
    public Response getUser(String userId)
    {
        createUserController=new CreateUserController();
        return createUserController.getUser(userId);
    }
    @Step("Update User {0}{1}")
    public Response updateUser(String userId,CreateUserDTO createUserDTO)
    {
        createUserController =new CreateUserController();
        return  createUserController.updateUser(userId, createUserDTO);
    }
    @Step("Delete User {0}")
    public Response deleteUser(String userId)
    {
        createUserController=new CreateUserController();
        return createUserController.deleteUser(userId);
    }
}
