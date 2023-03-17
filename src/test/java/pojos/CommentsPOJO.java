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

public class CommentsPOJO {
    @Expose(serialize = false, deserialize = true)
    private int id;
    @Expose(serialize = false, deserialize = true)
    private int post_id;
    @Expose(serialize = false, deserialize = true)
    private String name;
    @Expose(serialize = false, deserialize = true)
    private String email;
    @Expose
    private String body;

    public CommentsPOJO (String body){
        this.body = body;
    }
}
