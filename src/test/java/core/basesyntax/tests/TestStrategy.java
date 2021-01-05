package core.basesyntax.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStrategy {
    private static final OperationStrategy balanceStrategy = new BalanceStrategy();
    private static final OperationStrategy purchaseStrategy = new PurchaseStrategy();
    private static final OperationStrategy returnStrategy = new ReturnStrategy();
    private static final OperationStrategy supplyStrategy = new SupplyStrategy();
    private static TransactionDto transactionDto;
    private static Operation operation;
    private static Fruit fruit;

    @Before
    public void fillTransaction() {
        operation = Operation.BALANCE;
        fruit = new Fruit("banana");
        transactionDto = new TransactionDto(operation, fruit, 100);
        balanceStrategy.apply(transactionDto);
    }

    @After
    public void cleanStorage() {
        if (Storage.getFruits() != null) {
            Storage.getFruits().clear();
        }
    }

    @Test
    public void checkBalanceCorrect() {
        assertEquals(Storage.getFruits().size(), 1, "Size must be 1");
        assertEquals(Storage.getFruits().get(fruit), 100);
    }

    @Test
    public void checkPurchaseCorrect() {
        Operation operation = Operation.PURCHASE;
        Fruit fruit = new Fruit("banana");
        transactionDto = new TransactionDto(operation, fruit, 20);
        purchaseStrategy.apply(transactionDto);
        assertEquals(Storage.getFruits().size(), 1, "Size must be 1");
        assertEquals(Storage.getFruits().get(fruit), 80);
    }

    @Test
    public void checkReturnCorrect() {
        Operation operation = Operation.RETURN;
        Fruit fruit = new Fruit("banana");
        transactionDto = new TransactionDto(operation, fruit, 20);
        returnStrategy.apply(transactionDto);
        assertEquals(Storage.getFruits().size(), 1, "Size must be 1");
        assertEquals(Storage.getFruits().get(fruit), 120);
    }

    @Test
    public void checkSupplyCorrect() {
        Operation operation = Operation.RETURN;
        Fruit fruit = new Fruit("banana");
        transactionDto = new TransactionDto(operation, fruit, 20);
        supplyStrategy.apply(transactionDto);
        assertEquals(Storage.getFruits().size(), 1, "Size must be 1");
        assertEquals(Storage.getFruits().get(fruit), 120);
    }

    @Test(expected = RuntimeException.class)
    public void purchaseStrategyException() {
        Operation operation = Operation.PURCHASE;
        Fruit fruit = new Fruit("banana");
        transactionDto = new TransactionDto(operation, fruit, 110);
        purchaseStrategy.apply(transactionDto);

    }

    @Test(expected = NoSuchElementException.class)
    public void purchaseStrategyExceptionNotHaveProduct() {
        Operation operation = Operation.PURCHASE;
        Fruit fruit = new Fruit("apple");
        transactionDto = new TransactionDto(operation, fruit, 110);
        purchaseStrategy.apply(transactionDto);

    }
}
