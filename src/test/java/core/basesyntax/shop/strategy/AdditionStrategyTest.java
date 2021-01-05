package core.basesyntax.shop.strategy;

import static org.junit.Assert.assertEquals;

import core.basesyntax.shop.db.Storage;
import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.model.Operation;
import core.basesyntax.shop.model.TransactionDto;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdditionStrategyTest {
    private static OperationStrategy strategy;
    private static TransactionDto bananaTransactionDto;
    private static TransactionDto appleTransactionDto;

    @BeforeClass
    public static void beforeClass() {
        bananaTransactionDto = new TransactionDto(Operation.SUPPLY,
                new Fruit("Banana"), 20);
        appleTransactionDto = new TransactionDto(Operation.SUPPLY,
                new Fruit("Apple"), 20);
        strategy = new AdditionStrategy();
    }

    @After
    public void tearDown() {
        Storage.fruitBalance.clear();
    }

    @Test
    public void apply_OK() {
        strategy.apply(bananaTransactionDto);
        strategy.apply(bananaTransactionDto);
        strategy.apply(appleTransactionDto);
        Integer bananaQuantity = Storage.fruitBalance.get(bananaTransactionDto.getFruit());
        Integer appleQuantity = Storage.fruitBalance.get(appleTransactionDto.getFruit());
        assertEquals(40, bananaQuantity.intValue());
        assertEquals(20, appleQuantity.intValue());
    }
}
