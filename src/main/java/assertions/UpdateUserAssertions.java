package assertions;

import dtos.response.UpdateUserResponseDTO;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Objects;

public class UpdateUserAssertions {
    Response actual;
    UpdateUserResponseDTO updateUserResponseDTO;

    public UpdateUserAssertions checkThat(Response response) {
        actual = response;
        updateUserResponseDTO = Objects.requireNonNull(response.jsonPath().getObject("", UpdateUserResponseDTO.class));
        return this;
    }

    public UpdateUserAssertions checkName(String name) {
        Assert.assertTrue(updateUserResponseDTO.getName().equalsIgnoreCase(name));
        return this;
    }

    public UpdateUserAssertions hasStatusCode(int code)
    {
        Assert.assertTrue(actual.statusCode()==code);
        return this;

    }

}

