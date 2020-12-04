package oap.cookbook.storage;

import oap.id.Identifier;
import oap.storage.MemoryStorage;

public class SlaveUserStorage extends MemoryStorage<String, User> {
    public SlaveUserStorage() {
        super( Identifier.<User>forId( u -> u.id ).build(), Lock.SERIALIZED );
    }
}
