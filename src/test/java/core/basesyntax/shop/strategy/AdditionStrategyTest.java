package core.basesyntax.shop.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.shop.db.Storage;
import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.model.Operation;
import core.basesyntax.shop.model.TransactionDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AdditionStrategyTest {
    private static OperationStrategy strategy;
    private static TransactionDto bananaTransactionDto;
    private static TransactionDto appleTransactionDto;

    @BeforeAll
    public static void beforeAll() {
        bananaTransactionDto = new TransactionDto(Operation.SUPPLY,
                new Fruit("Banana"), 20);
        appleTransactionDto = new TransactionDto(Operation.SUPPLY,
                new Fruit("Apple"), 20);
        strategy = new AdditionStrategy();
    }

    @AfterEach
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
        assertEquals(2, Storage.fruitBalance.size());
        assertEquals(40, bananaQuantity);
        assertEquals(20, appleQuantity);
    }
}
