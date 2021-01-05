package core.basesyntax.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.strategies.BalanceStrategy;
import core.basesyntax.strategy.strategies.PurchaseStrategy;
import core.basesyntax.strategy.strategies.ReturnStrategy;
import core.basesyntax.strategy.strategies.SupplyStrategy;
import org.junit.Test;

public class StrategyTest {
    private static final Fruit BANANA = new Fruit("banana");
    private static final Fruit APPLE = new Fruit("apple");
    private TransactionDto dto;

    @Test(expected = Test.None.class)
    public void validData() {
        dto = new TransactionDto(Operation.BALANCE, BANANA, 50);
        OperationStrategy.chooseTheStrategy(dto);
    }

    @Test(expected = RuntimeException.class)
    public void invalidOperation() {
        dto = new TransactionDto(Operation.valueOf("CATCH"), APPLE, 60);
        OperationStrategy.chooseTheStrategy(dto);
    }

    @Test
    public void balanceStrategyCheck_OK() {
        dto = new TransactionDto(Operation.BALANCE, BANANA, 40);
        new BalanceStrategy().apply(dto);
        assertNotNull(Storage.storage);
    }

    @Test
    public void balanceStrategyCheck_NotOK() {
        dto = new TransactionDto(Operation.BALANCE, BANANA, -20);
        new BalanceStrategy().apply(dto);
        assertNotNull(Storage.storage);
        assertEquals(Integer.valueOf(0), Storage.storage.get(BANANA));
    }

    @Test
    public void purchaseCheck_OK() {
        Storage.storage.put(APPLE, 50);
        dto = new TransactionDto(Operation.PURCHASE, APPLE, 20);
        new PurchaseStrategy().apply(dto);
        assertEquals(Integer.valueOf(30), Storage.storage.get(APPLE));
    }

    @Test(expected = RuntimeException.class)
    public void purchaseCheck_NegativeAmount() {
        Storage.storage.put(APPLE, 40);
        dto = new TransactionDto(Operation.PURCHASE, APPLE, -10);
        new PurchaseStrategy().apply(dto);
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
    public void returnCheck_NegativeAmount() {
        Storage.storage.put(BANANA, 10);
        dto = new TransactionDto(Operation.RETURN, BANANA, 10);
        new ReturnStrategy().apply(dto);
        assertEquals(Integer.valueOf(20), Storage.storage.get(BANANA));
    }

    @Test
    public void supplyCheck_OK() {
        Storage.storage.put(APPLE, 20);
        dto = new TransactionDto(Operation.SUPPLY, APPLE, 20);
        new SupplyStrategy().apply(dto);
        assertEquals(Integer.valueOf(40), Storage.storage.get(APPLE));
    }

    @Test(expected = RuntimeException.class)
    public void supplyCheck_NegativeValue() {
        Storage.storage.put(APPLE, 20);
        dto = new TransactionDto(Operation.SUPPLY, APPLE, -15);
        new SupplyStrategy().apply(dto);
    }
}
