package core.basesyntax.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ShopStorageTest {

    private ShopStorage storage;

    @BeforeEach
    void setUp() {
        storage = new ShopStorage();
    }

    @Test
    void create_ShouldReturnTrue_WhenKeyDoesNotExist() {
        boolean result = storage.create("apple", 10);
        assertTrue(result);
        assertEquals(10, storage.read("apple"));
    }

    @Test
    void create_ShouldReturnFalse_WhenKeyAlreadyExists() {
        storage.create("apple", 10);
        boolean result = storage.create("apple", 20);
        assertFalse(result);
        assertEquals(10, storage.read("apple")); // not changed
    }

    @Test
    void read_ShouldReturnNull_WhenKeyDoesNotExist() {
        assertNull(storage.read("banana"));
    }

    @Test
    void update_ShouldChangeValue_WhenKeyExists() {
        storage.create("apple", 10);
        storage.update("apple", 50);
        assertEquals(50, storage.read("apple"));
    }

    @Test
    void update_ShouldThrowException_WhenKeyDoesNotExist() {
        assertThrows(IllegalArgumentException.class,
                () -> storage.update("banana", 10));
    }

    @Test
    void delete_ShouldRemoveKey_WhenKeyExists() {
        storage.create("apple", 10);
        storage.delete("apple");
        assertNull(storage.read("apple"));
    }

    @Test
    void delete_ShouldThrowException_WhenKeyDoesNotExist() {
        assertThrows(IllegalArgumentException.class,
                () -> storage.delete("banana"));
    }

    @Test
    void fullCrudFlow_ShouldWorkCorrectly() {
        assertTrue(storage.create("apple", 10));
        assertEquals(10, storage.read("apple"));

        storage.update("apple", 20);
        assertEquals(20, storage.read("apple"));

        storage.delete("apple");
        assertNull(storage.read("apple"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"apple", "banana", "orange"})
    void create_ShouldWork_ForDifferentKeys(String key) {
        assertTrue(storage.create(key, 5));
    }

    @Test
    void create_NullKey_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> storage.create(null, 10));
    }
}
