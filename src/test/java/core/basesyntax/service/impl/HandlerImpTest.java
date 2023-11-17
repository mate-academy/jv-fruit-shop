package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.db.InMemoryStorage;
import core.basesyntax.model.ItemTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HandlerImpTest {

    private final Handler handler = new HandlerImpl();

    @AfterAll
    public static void clearStorageAfterTest() {
        InMemoryStorage.items.clear();
    }

    @BeforeEach
    public void clearStorage() {
        InMemoryStorage.items.clear();
    }

    @Test
    void handle_ok() {
        List<ItemTransaction> input = new ArrayList<>();
        input.add(new ItemTransaction(Operation.BALANCE,"banana", 20));
        input.add(new ItemTransaction(Operation.BALANCE,"apple", 100));
        input.add(new ItemTransaction(Operation.SUPPLY,"banana", 100));
        input.add(new ItemTransaction(Operation.PURCHASE,"banana", 13));
        input.add(new ItemTransaction(Operation.RETURN,"apple", 10));
        input.add(new ItemTransaction(Operation.PURCHASE,"apple", 20));
        input.add(new ItemTransaction(Operation.PURCHASE,"banana", 5));
        input.add(new ItemTransaction(Operation.SUPPLY,"banana", 50));
        handler.handle(input);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("banana", 152);
        expected.put("apple", 90);
        assertEquals(expected, InMemoryStorage.items);
    }

    @Test
    void handle_nullData() {
        assertThrows(NullPointerException.class, () ->
                handler.handle(null));
    }
}
