package oap.cookbook.storage;

import oap.id.Identifier;
import oap.storage.MemoryStorage;

public class UserStorage extends MemoryStorage<String, User> {
    public UserStorage() {
        super( Identifier.<User>forId( u -> u.id, ( u, id ) -> u.id = id )
            .suggestion( u -> u.email )
            .build(), Lock.SERIALIZED );
    }
}
