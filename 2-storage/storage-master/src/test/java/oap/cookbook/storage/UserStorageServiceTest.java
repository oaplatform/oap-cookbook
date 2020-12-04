package oap.cookbook.storage;

import oap.application.testng.KernelFixture;
import oap.storage.mongo.memory.MongoFixture;
import oap.testng.Fixtures;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserStorageServiceTest extends Fixtures {

    private final KernelFixture kernel;

    {
        fixture( new MongoFixture() );
        fixture( kernel = new KernelFixture( "/application.test.conf" ) );
    }

    @Test
    public void store() {
        UserStorage storage = kernel.service( UserStorage.class );
        storage.store( new User( "john@google.com", "John Smith" ) );
        List<User> users = storage.list();
        assertThat( users )
            .contains( new User( "JHNGGLCM", "john@google.com", "John Smith" ) );
    }

}
