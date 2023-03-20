package pojos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PostsPojo {

    @Expose(serialize = false, deserialize = true)
    private int id;
    @Expose (serialize = false, deserialize = true)
    private int user_id;
    @Expose
    private String title;
    @Expose
    private String body;

    public PostsPojo(String title, String body){
        this.title = title;
        this.body = body;
    }
}
