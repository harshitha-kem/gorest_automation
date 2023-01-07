package assertions;

import dtos.response.UpdateUserResponseDTO;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Objects;

public class UpdateUserAssertions {
    Response actual;
    UpdateUserResponseDTO updateUserResponseDTO;

    @Step("Check the response object of update user{0}")
    public UpdateUserAssertions checkThat(Response response) {
        actual = response;
        updateUserResponseDTO = Objects.requireNonNull(response.jsonPath().getObject("", UpdateUserResponseDTO.class));
        return this;
    }
    @Step("Check the updated name {0}")
    public UpdateUserAssertions checkName(String name) {
        Assert.assertTrue(updateUserResponseDTO.getName().equalsIgnoreCase(name));
        return this;
    }
    @Step("check the status code of update user {0}")
    public UpdateUserAssertions hasStatusCode(int code)
    {
        Assert.assertTrue(actual.statusCode()==code);
        return this;

    }
}

