package oap.cookbook.migrations;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import oap.id.Id;

@ToString
@EqualsAndHashCode
public class User {
    @Id
    public String email;
    public String firstName;
    public String lastName;

    public User( String email, String firstName, String lastName ) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
