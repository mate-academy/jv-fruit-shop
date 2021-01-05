package core.basesyntax.strategy;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReductionStrategyTest {
    public static ReductionStrategy reductionStrategy;

    @BeforeClass
    public static void beforeClass() {
        reductionStrategy = new ReductionStrategy();
    }

    @After
    public void tearDown() {
        Storage.fruits.removeAll(Storage.fruits);
    }

    @Test
    public void subtraction_Ok() {
        Storage.fruits.add(new Fruit("banana"));
        reductionStrategy.apply(new TransactionDto(Operation.PURCHASE,
                new Fruit("banana"), 1));
        Integer actual = Storage.fruits.size();
        assertEquals(Integer.valueOf(0), actual);
    }

    @Test(expected = RuntimeException.class)
    public void subtractionBadData_Ok() {
        reductionStrategy.apply(new TransactionDto(Operation.PURCHASE,
                new Fruit("banana"), -10));
    }

    @Test(expected = RuntimeException.class)
    public void subtractionMoreThanWeHave_Ok() {
        reductionStrategy.apply(new TransactionDto(Operation.PURCHASE,
                new Fruit("banana"), 50));
    }
}
