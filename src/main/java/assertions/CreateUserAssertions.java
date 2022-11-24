package assertions;

import dtos.response.CreateUserResponseDTO;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Objects;

public class CreateUserAssertions
{
    Response actual;
    CreateUserResponseDTO createUserResponseDTO;
    public CreateUserAssertions checkThat(Response response)
    {
        actual=response;
        createUserResponseDTO= Objects.requireNonNull(response.jsonPath().getObject("",CreateUserResponseDTO.class));
        return this;
    }
    public CreateUserAssertions hasStatusCode(int statusCode)
    {
        Assert.assertTrue(actual.statusCode()==statusCode);
        return this;
    }
}
