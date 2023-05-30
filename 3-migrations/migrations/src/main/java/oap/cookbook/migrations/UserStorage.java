package oap.cookbook.migrations;

import oap.id.Identifier;
import oap.storage.MemoryStorage;

import static oap.storage.Storage.Lock.SERIALIZED;

public class UserStorage extends MemoryStorage<String, User> {
    public UserStorage() {
        super( Identifier.forAnnotationFixed(), SERIALIZED );
    }
}
