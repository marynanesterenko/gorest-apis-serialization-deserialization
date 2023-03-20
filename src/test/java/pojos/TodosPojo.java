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
public class TodosPojo {

    @Expose(serialize = false, deserialize = true)
    private int id;
    @Expose (serialize = false, deserialize = true)
    private int user_id;
    @Expose
    private String title;
    @Expose
    private String due_on;
    @Expose
    private String status;

    public TodosPojo(String title, String due_on, String status){
        this.title = title;
        this.status = status;
        this.due_on = due_on;
    }

}
