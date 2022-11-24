package assertions;

import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Objects;

public class DeleteUserAssertions {
    Response actual;
    public DeleteUserAssertions checkThat(Response response)
    {
        actual=response;
        return this;
    }
    public DeleteUserAssertions hasStatusCode(int statusCode)
    {
        Assert.assertTrue(actual.statusCode()==statusCode);
        return this;
    }
}
