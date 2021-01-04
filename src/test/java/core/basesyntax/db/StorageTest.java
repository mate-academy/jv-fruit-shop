package core.basesyntax.db;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StorageTest {
    @Test
    void initialSize_Ok() {
        assertEquals(0, Storage.fruits.size());
    }
}
