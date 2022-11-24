package steps;

import dtos.request.CreateUserDTO;
import io.restassured.response.Response;
import requests.CreateUserController;

public class GoRestSteps
{
    CreateUserController createUserController;
    public Response createUser(CreateUserDTO createUserDTO)
    {
        CreateUserController createUserController=new CreateUserController();
        return createUserController.createUser(createUserDTO);
    }
    public Response getUser(String userId)
    {
        createUserController=new CreateUserController();
        return createUserController.getUser(userId);
    }
    public Response updateUser(String userId,CreateUserDTO createUserDTO)
    {
        createUserController =new CreateUserController();
        return  createUserController.updateUser(userId, createUserDTO);
    }
    public Response deleteUser(String userId)
    {
        createUserController=new CreateUserController();
        return createUserController.deleteUser(userId);
    }
}
