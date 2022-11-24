package assertions;

import dtos.response.GetUserResponseDTO;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Objects;

public class GetUserAssertions {
    Response actual;
    GetUserResponseDTO getUserResponseDTO;
    public GetUserAssertions checkThat(Response response)
    {
        actual=response;
        getUserResponseDTO= Objects.requireNonNull(response.jsonPath().getObject("",GetUserResponseDTO.class));
        return this;
    }
    public GetUserAssertions checkId(String userId)
    {
        Assert.assertTrue(getUserResponseDTO.getId().equalsIgnoreCase(userId));
        return this;
    }
    public GetUserAssertions hasStatusCode(int statusCode)
    {
        Assert.assertTrue(actual.statusCode()==statusCode);
        return this;
    }

}
