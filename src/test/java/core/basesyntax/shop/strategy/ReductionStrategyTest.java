package core.basesyntax.shop.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.shop.db.Storage;
import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.model.Operation;
import core.basesyntax.shop.model.TransactionDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReductionStrategyTest {
    private static OperationStrategy strategy;
    private static TransactionDto bananaTransactionDto;
    private static TransactionDto appleTransactionDto;

    @BeforeAll
    public static void beforeAll() {
        bananaTransactionDto = new TransactionDto(Operation.PURCHASE,
                new Fruit("Banana"), 20);
        appleTransactionDto = new TransactionDto(Operation.PURCHASE,
                new Fruit("Apple"), 20);
        strategy = new ReductionStrategy();
    }

    @BeforeEach
    public void setUp() {
        Storage.fruitBalance.put(new Fruit("Banana"), 60);
        Storage.fruitBalance.put(new Fruit("Apple"), 30);
    }

    @AfterEach
    public void tearDown() {
        Storage.fruitBalance.clear();
    }

    @Test
    public void apply_OK() {
        Integer bananaQuantity;
        strategy.apply(bananaTransactionDto);
        bananaQuantity = Storage.fruitBalance.get(bananaTransactionDto.getFruit());
        assertEquals(40, bananaQuantity);

        strategy.apply(bananaTransactionDto);
        bananaQuantity = Storage.fruitBalance.get(bananaTransactionDto.getFruit());
        assertEquals(20, bananaQuantity);

        strategy.apply(appleTransactionDto);
        Integer appleQuantity = Storage.fruitBalance.get(appleTransactionDto.getFruit());
        assertEquals(10, appleQuantity);

        assertEquals(2, Storage.fruitBalance.size());
    }

    @Test
    public void apply_ThrowIllegalStateException() {
        strategy.apply(appleTransactionDto);
        assertThrows(IllegalStateException.class, () -> strategy.apply(appleTransactionDto));
    }
}
