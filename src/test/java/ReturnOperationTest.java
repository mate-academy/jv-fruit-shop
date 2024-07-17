import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.ReturnOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReturnOperationTest {
    private Storage storage;

    @BeforeEach
    public void setUp() {
        storage = new Storage();
        storage.addFruit("apple", 30);
    }

    @Test
    public void testReturnOperation() {
        FruitTransaction transaction = new FruitTransaction(FruitTransaction.Operation.RETURN,
                "apple", 20);
        new ReturnOperation().handle(transaction, storage);
        assertEquals((Integer) 50, storage.getFruitQuantities().get("apple"));
    }
}
