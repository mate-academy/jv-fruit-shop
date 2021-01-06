package core.basesyntax.strategy;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.strategies.BalanceStrategy;
import core.basesyntax.strategy.strategies.PurchaseStrategy;
import core.basesyntax.strategy.strategies.ReturnStrategy;
import core.basesyntax.strategy.strategies.SupplyStrategy;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class StrategyTest {
    private static final Fruit BANANA = new Fruit("banana");
    private static final Fruit APPLE = new Fruit("apple");
    private static Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
    private TransactionDto dto;

    @BeforeClass
    public static void beforeClass() {
        operationStrategyMap.put(Operation.BALANCE, new BalanceStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        operationStrategyMap.put(Operation.RETURN, new ReturnStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyStrategy());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidOperation() {
        dto = new TransactionDto(Operation.valueOf("CATCH"), APPLE, 60);
    }

    @Test
    public void balanceStrategyCheck_OK() {
        dto = new TransactionDto(Operation.BALANCE, BANANA, 40);
        new BalanceStrategy().apply(dto);
        assertEquals(Integer.valueOf(40), Storage.storage.get(BANANA));
    }

    @Test
    public void purchaseCheck_OK() {
        Storage.storage.put(APPLE, 50);
        dto = new TransactionDto(Operation.PURCHASE, APPLE, 20);
        new PurchaseStrategy().apply(dto);
        assertEquals(Integer.valueOf(30), Storage.storage.get(APPLE));
    }

    @Test(expected = RuntimeException.class)
    public void purchaseCheck_TooBigAmount() {
        Storage.storage.put(APPLE, 50);
        dto = new TransactionDto(Operation.PURCHASE, APPLE, 1000000000);
        new PurchaseStrategy().apply(dto);
    }

    @Test
    public void returnCheck_OK() {
        Storage.storage.put(BANANA, 50);
        dto = new TransactionDto(Operation.RETURN, BANANA, 20);
        new ReturnStrategy().apply(dto);
        assertEquals(Integer.valueOf(70), Storage.storage.get(BANANA));
    }

    @Test
    public void supplyCheck_OK() {
        Storage.storage.put(APPLE, 20);
        dto = new TransactionDto(Operation.SUPPLY, APPLE, 20);
        new SupplyStrategy().apply(dto);
        assertEquals(Integer.valueOf(40), Storage.storage.get(APPLE));
    }

    @After
    public void afterClass() {
        Storage.storage.clear();
    }
}
