package core.basesyntax.shop.strategy;

import static org.junit.Assert.assertEquals;

import core.basesyntax.shop.db.Storage;
import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.model.Operation;
import core.basesyntax.shop.model.TransactionDto;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReductionStrategyTest {
    private static OperationStrategy strategy;
    private static TransactionDto bananaTransactionDto;
    private static TransactionDto appleTransactionDto;

    @BeforeClass
    public static void beforeClass() {
        bananaTransactionDto = new TransactionDto(Operation.PURCHASE,
                new Fruit("Banana"), 20);
        appleTransactionDto = new TransactionDto(Operation.PURCHASE,
                new Fruit("Apple"), 20);
        strategy = new ReductionStrategy();
    }

    @Before
    public void setUp() {
        Storage.fruitBalance.put(new Fruit("Banana"), 60);
        Storage.fruitBalance.put(new Fruit("Apple"), 30);
    }

    @After
    public void tearDown() {
        Storage.fruitBalance.clear();
    }

    @Test
    public void apply_OK() {
        Integer bananaQuantity;
        strategy.apply(bananaTransactionDto);
        bananaQuantity = Storage.fruitBalance.get(bananaTransactionDto.getFruit());
        assertEquals(40, bananaQuantity.intValue());

        strategy.apply(bananaTransactionDto);
        bananaQuantity = Storage.fruitBalance.get(bananaTransactionDto.getFruit());
        assertEquals(20, bananaQuantity.intValue());

        strategy.apply(appleTransactionDto);
        Integer appleQuantity = Storage.fruitBalance.get(appleTransactionDto.getFruit());
        assertEquals(10, appleQuantity.intValue());

        assertEquals(2, Storage.fruitBalance.size());
    }

    @Test(expected = IllegalStateException.class)
    public void apply_ThrowIllegalStateException() {
        strategy.apply(appleTransactionDto);
        strategy.apply(appleTransactionDto);
    }
}
