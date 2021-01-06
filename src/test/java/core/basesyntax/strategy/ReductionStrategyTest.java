package core.basesyntax.strategy;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReductionStrategyTest {
    private static OperationStrategy operationStrategy;
    private static Fruit banana;

    @BeforeClass
    public static void initialization() {
        operationStrategy = new ReductionStrategy();
        banana = new Fruit("banana");
    }

    @Before
    public void clearStorage() {
        Storage.storage.clear();
    }

    @Test
    public void apply_correctValue_ok() {
        Storage.storage.put(banana, 100);
        operationStrategy.apply(new TransactionDto(banana, 50, Operation.PURCHASE));
        Assert.assertEquals(Integer.valueOf(50), Storage.storage.get(banana));
    }

    @Test(expected = RuntimeException.class)
    public void apply_nullValue_notOk() {
        operationStrategy.apply(null);
    }
}
