package oap.cookbook.storage;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@ToString
@EqualsAndHashCode
public class User implements Serializable {
    public String id;
    public String email;
    public String name;

    public User( String id, String email, String name ) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public User( String email, String name ) {
        this.email = email;
        this.name = name;
    }
}
