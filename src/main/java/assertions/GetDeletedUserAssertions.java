package assertions;

import dtos.response.GetDeletedUserResponseDTO;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Objects;

public class GetDeletedUserAssertions {
    Response actual;
    GetDeletedUserResponseDTO getDeletedUserResponseDTO;
    public GetDeletedUserAssertions checkThat(Response response)
    {
        actual=response;
        getDeletedUserResponseDTO=Objects.requireNonNull(response.jsonPath().getObject("",GetDeletedUserResponseDTO.class));
        return this;

    }
    public GetDeletedUserAssertions hasStatusCode(int statusCode)
    {
        Assert.assertTrue(actual.statusCode()==statusCode);
        return this;
    }

    public GetDeletedUserAssertions hasMessage(String message)
    {
        Assert.assertTrue(getDeletedUserResponseDTO.getMessage().equalsIgnoreCase(message));
        return this;
    }
}
