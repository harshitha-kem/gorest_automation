package assertions;

import dtos.response.GetDeletedUserResponseDTO;
import dtos.response.GetUserResponseDTO;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Objects;

public class GetUserAssertions {
    Response actual;
    GetUserResponseDTO getUserResponseDTO;
    @Step("Check get user response object {0}")
    public GetUserAssertions checkThat(Response response)
    {
        actual=response;
        getUserResponseDTO= Objects.requireNonNull(response.jsonPath().getObject("",GetUserResponseDTO.class));
        return this;
    }
    @Step("Check the user id {0}")
    public GetUserAssertions checkId(String userId)
    {
        Assert.assertTrue(getUserResponseDTO.getId().equalsIgnoreCase(userId));
        return this;
    }
    @Step("check the status code of get user{0}")
    public GetUserAssertions hasStatusCode(int statusCode)
    {
        Assert.assertTrue(actual.statusCode()==statusCode);
        return this;
    }
}
