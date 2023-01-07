package assertions;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Objects;

public class DeleteUserAssertions {
    Response actual;
    @Step("Check the response object of deleted user {0}")
    public DeleteUserAssertions checkThat(Response response)
    {
        actual=response;
        return this;
    }
    @Step("Check the status code of delete user{0}")
    public DeleteUserAssertions hasStatusCode(int statusCode)
    {
        Assert.assertTrue(actual.statusCode()==statusCode);
        return this;
    }
}
