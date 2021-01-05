package core.basesyntax.strategy;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdditionalStrategyTest {
    public static AdditionalStrategy additionalStrategy;

    @BeforeClass
    public static void beforeClass() {
        additionalStrategy = new AdditionalStrategy();
    }

    @After
    public void tearDown() {
        Storage.fruits.removeAll(Storage.fruits);
    }

    @Test
    public void additional_Ok() {
        additionalStrategy.apply(new TransactionDto(Operation.BALANCE,
                new Fruit("banana"), 20));
        Integer actul = Storage.fruits.size();
        assertEquals(Integer.valueOf(20), actul);
    }
}
