package oap.cookbook.storage;

import oap.application.testng.KernelFixture;
import oap.storage.Replicator;
import oap.storage.mongo.memory.MongoFixture;
import oap.testng.Fixtures;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MasterSlaveTest extends Fixtures {

    private final KernelFixture kernel;

    {
        fixture( new MongoFixture() );
        fixture( kernel = new KernelFixture( "/application.test.conf" ) );
    }

    @Test
    public void replica() {
        UserStorage master = kernel.service( "user-storage" );
        master.store( new User( "john@google.com", "John Smith" ) );

        kernel.<Replicator<String, User>>service( "user-replicator" ).replicateNow();

        SlaveUserStorage slave = kernel.service( "client-user-storage" );
        assertThat( slave.list() )
            .contains( new User( "JHNGGLCM", "john@google.com", "John Smith" ) );
    }

}
