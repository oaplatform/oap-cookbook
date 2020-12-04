package oap.cookbook.storage;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserStorageTest {

    @Test
    public void store() {
        UserStorage storage = new UserStorage();
        storage.store( new User( "john@google.com", "John Smith" ) );
        List<User> users = storage.list();
        assertThat( users )
            .contains( new User( "JHNGGLCM", "john@google.com", "John Smith" ) );
    }
}