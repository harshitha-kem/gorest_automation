package assertions;

import dtos.response.CreateUserResponseDTO;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Objects;

public class CreateUserAssertions
{
    Response actual;
    CreateUserResponseDTO createUserResponseDTO;
    @Step("Check create user response object {0}")
    public CreateUserAssertions checkThat(Response response)
    {
        actual=response;
        createUserResponseDTO= Objects.requireNonNull(response.jsonPath().getObject("",CreateUserResponseDTO.class));
        return this;
    }
    @Step("Check create user has status code {0}")
    public CreateUserAssertions hasStatusCode(int statusCode)
    {
        Assert.assertTrue(actual.statusCode()==statusCode);
        return this;
    }
}
