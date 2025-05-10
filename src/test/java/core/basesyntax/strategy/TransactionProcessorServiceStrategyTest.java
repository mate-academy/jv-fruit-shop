package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.db.FruitDb;
import core.basesyntax.db.HashMapFruitDb;
import core.basesyntax.model.Transaction.Operation;
import org.junit.jupiter.api.Test;

public class TransactionProcessorServiceStrategyTest {
    private final FruitDb db = new HashMapFruitDb();
    private final TransactionProcessorServiceStrategy strategy
            = new TransactionProcessorServiceStrategy(db);

    @Test
    void get_existingStrategy_success() {
        for (Operation operation : Operation.values()) {
            assertDoesNotThrow(() -> strategy.get(operation));
        }
    }

    @Test
    void get_nonexistentStrategy_fail() {
        assertThrows(RuntimeException.class, () -> strategy.get(null));
    }
}
