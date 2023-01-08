
package dtos.request;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;


public class CreatePostDTO {


    private String body;

    private String title;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
