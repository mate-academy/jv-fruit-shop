package tests;

import static org.junit.Assert.assertThrows;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;
import core.basesyntax.OperationHandler;
import core.basesyntax.OperationStrategy;
import core.basesyntax.OperationStrategyImpl;
import core.basesyntax.PurchaseOperation;
import core.basesyntax.ReturnOperation;
import core.basesyntax.ShopService;
import core.basesyntax.ShopServiceImpl;
import core.basesyntax.SupplyOperation;
import core.basesyntax.strategy.BalanceOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopServiceTest {
    private ShopService shopService;
    private List<FruitTransaction> transactions;

    @BeforeEach
    public void setUp() {
        final Map<Operation, OperationHandler> operationHandlers = Map.of(
                Operation.BALANCE, new BalanceOperation(),
                Operation.PURCHASE, new PurchaseOperation(),
                Operation.RETURN, new ReturnOperation(),
                Operation.SUPPLY, new SupplyOperation()
        );
        final OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        shopService = new ShopServiceImpl(operationStrategy);
        transactions = new ArrayList<>();
    }

    @Test
    public void processTransactions_balanceOperation_ok() {
        final FruitTransaction balance = new FruitTransaction();
        balance.setOperation(Operation.BALANCE);
        balance.setFruit("banana");
        balance.setQuantity(100);
        transactions.add(balance);

        shopService.process(transactions);
        final Map<String, Integer> storage = shopService.getStorage();

        Assertions.assertEquals(100, (int) storage.get("banana"));
    }

    @Test
    public void processTransactions_supplyOperation_ok() {
        final FruitTransaction balance = new FruitTransaction();
        balance.setOperation(Operation.BALANCE);
        balance.setFruit("banana");
        balance.setQuantity(100);
        transactions.add(balance);

        final FruitTransaction supply = new FruitTransaction();
        supply.setOperation(Operation.SUPPLY);
        supply.setFruit("banana");
        supply.setQuantity(50);
        transactions.add(supply);

        shopService.process(transactions);
        final Map<String, Integer> storage = shopService.getStorage();

        Assertions.assertEquals(150, (int) storage.get("banana"));
    }

    @Test
    public void processTransactions_supplyNewFruit_ok() {
        final FruitTransaction supply = new FruitTransaction();
        supply.setOperation(Operation.SUPPLY);
        supply.setFruit("apple");
        supply.setQuantity(30);
        transactions.add(supply);

        shopService.process(transactions);
        final Map<String, Integer> storage = shopService.getStorage();

        Assertions.assertEquals(30, (int) storage.get("apple"));
    }

    @Test
    public void processTransactions_negativeSupplyQuantity_notOk() {
        final FruitTransaction balance = new FruitTransaction();
        balance.setOperation(Operation.BALANCE);
        balance.setFruit("banana");
        balance.setQuantity(100);
        transactions.add(balance);

        final FruitTransaction supply = new FruitTransaction();
        supply.setOperation(Operation.SUPPLY);
        supply.setFruit("banana");
        supply.setQuantity(-20); // Негативное количество
        transactions.add(supply);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> shopService.process(transactions));
        Assertions.assertEquals("Invalid quantity: -20", exception.getMessage());
    }

    @Test
    public void processTransactions_supplyWithoutBalance_ok() {
        final FruitTransaction supply = new FruitTransaction();
        supply.setOperation(Operation.SUPPLY);
        supply.setFruit("banana");
        supply.setQuantity(50);
        transactions.add(supply);

        shopService.process(transactions);
        final Map<String, Integer> storage = shopService.getStorage();

        Assertions.assertEquals(50, (int) storage.get("banana"));
    }

    @Test
    public void processTransactions_combinedOperations_ok() {
        final FruitTransaction balance = new FruitTransaction();
        balance.setOperation(Operation.BALANCE);
        balance.setFruit("banana");
        balance.setQuantity(100);
        transactions.add(balance);

        final FruitTransaction supply = new FruitTransaction();
        supply.setOperation(Operation.SUPPLY);
        supply.setFruit("banana");
        supply.setQuantity(50);
        transactions.add(supply);

        final FruitTransaction purchase = new FruitTransaction();
        purchase.setOperation(Operation.PURCHASE);
        purchase.setFruit("banana");
        purchase.setQuantity(30);
        transactions.add(purchase);

        shopService.process(transactions);
        final Map<String, Integer> storage = shopService.getStorage();

        Assertions.assertEquals(120, (int) storage.get("banana"));
    }

    @Test
    public void processTransactions_multipleBalanceOperations_ok() {
        final FruitTransaction balanceApple = new FruitTransaction();
        balanceApple.setOperation(Operation.BALANCE);
        balanceApple.setFruit("apple");
        balanceApple.setQuantity(150);
        transactions.add(balanceApple);

        final FruitTransaction balanceBanana = new FruitTransaction();
        balanceBanana.setOperation(Operation.BALANCE);
        balanceBanana.setFruit("banana");
        balanceBanana.setQuantity(100);
        transactions.add(balanceBanana);

        shopService.process(transactions);
        final Map<String, Integer> storage = shopService.getStorage();

        Assertions.assertEquals(150, (int) storage.get("apple"));
        Assertions.assertEquals(100, (int) storage.get("banana"));
    }

    @Test
    public void processTransactions_negativeBalanceQuantity_notOk() {
        final FruitTransaction balance = new FruitTransaction();
        balance.setOperation(Operation.BALANCE);
        balance.setFruit("banana");
        balance.setQuantity(-50);
        transactions.add(balance);

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> shopService.process(transactions));
        Assertions.assertEquals("Balance cannot be negative", exception.getMessage());
    }

    @Test
    public void processTransactions_balanceAndSupplyCombined_ok() {
        final FruitTransaction balance = new FruitTransaction();
        balance.setOperation(Operation.BALANCE);
        balance.setFruit("banana");
        balance.setQuantity(100);
        transactions.add(balance);

        final FruitTransaction supply = new FruitTransaction();
        supply.setOperation(Operation.SUPPLY);
        supply.setFruit("banana");
        supply.setQuantity(50);
        transactions.add(supply);

        shopService.process(transactions);
        final Map<String, Integer> storage = shopService.getStorage();

        Assertions.assertEquals(150, (int) storage.get("banana"));
    }

    @Test
    public void processTransactions_multipleOperationsForSameFruit_ok() {
        final FruitTransaction balance = new FruitTransaction();
        balance.setOperation(Operation.BALANCE);
        balance.setFruit("banana");
        balance.setQuantity(100);
        transactions.add(balance);

        final FruitTransaction supply = new FruitTransaction();
        supply.setOperation(Operation.SUPPLY);
        supply.setFruit("banana");
        supply.setQuantity(50);
        transactions.add(supply);

        final FruitTransaction purchase = new FruitTransaction();
        purchase.setOperation(Operation.PURCHASE);
        purchase.setFruit("banana");
        purchase.setQuantity(30);
        transactions.add(purchase);

        shopService.process(transactions);
        final Map<String, Integer> storage = shopService.getStorage();

        Assertions.assertEquals(120, (int) storage.get("banana"));
    }

    @Test
    public void processTransactions_purchaseMoreThanAvailable_notOk() {
        final FruitTransaction balance = new FruitTransaction();
        balance.setOperation(Operation.BALANCE);
        balance.setFruit("banana");
        balance.setQuantity(100);
        transactions.add(balance);

        final FruitTransaction purchase = new FruitTransaction();
        purchase.setOperation(Operation.PURCHASE);
        purchase.setFruit("banana");
        purchase.setQuantity(150);
        transactions.add(purchase);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> shopService.process(transactions));
        Assertions.assertEquals("Not enough fruit in storage for purchase: banana", exception.getMessage());
    }

    @Test
    public void processTransactions_purchaseFruitNotInStorage_notOk() {
        transactions.clear();

        final FruitTransaction purchase = new FruitTransaction();
        purchase.setOperation(Operation.PURCHASE);
        purchase.setFruit("orange");
        purchase.setQuantity(30);
        transactions.add(purchase);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> shopService.process(transactions));
        Assertions.assertEquals("Not enough fruit in storage for purchase: orange", exception.getMessage());
    }

    @Test
    public void processTransactions_combinedWithInvalidTransactions_notOk() {
        final FruitTransaction balance = new FruitTransaction();
        balance.setOperation(Operation.BALANCE);
        balance.setFruit("banana");
        balance.setQuantity(100);
        transactions.add(balance);

        final FruitTransaction invalidTransaction = new FruitTransaction();
        invalidTransaction.setOperation(Operation.SUPPLY);
        invalidTransaction.setFruit("banana");
        invalidTransaction.setQuantity(-50);
        transactions.add(invalidTransaction);

        final FruitTransaction purchase = new FruitTransaction();
        purchase.setOperation(Operation.PURCHASE);
        purchase.setFruit("banana");
        purchase.setQuantity(30);
        transactions.add(purchase);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> shopService.process(transactions));
        Assertions.assertEquals("Invalid quantity: -50", exception.getMessage());

        final Map<String, Integer> storage = shopService.getStorage();
        Assertions.assertEquals(100, (int) storage.get("banana"));
    }

    @Test
    public void processTransactions_unknownOperation_notOk() {
        FruitTransaction balance = new FruitTransaction(Operation.BALANCE, "banana", 100);
        transactions.add(balance);

        FruitTransaction unknownOperation = new FruitTransaction(null, "banana", 50);
        transactions.add(unknownOperation);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> shopService.process(transactions));
        Assertions.assertEquals("Unknown operation: null", exception.getMessage());

        Map<String, Integer> storage = shopService.getStorage();
        Assertions.assertEquals(100, (int) storage.get("banana"));
    }

    @Test
    public void processTransactions_variousOperations_ok() {
        final FruitTransaction balance = new FruitTransaction();
        balance.setOperation(Operation.BALANCE);
        balance.setFruit("apple");
        balance.setQuantity(100);
        transactions.add(balance);

        final FruitTransaction supply = new FruitTransaction();
        supply.setOperation(Operation.SUPPLY);
        supply.setFruit("apple");
        supply.setQuantity(50);
        transactions.add(supply);

        final FruitTransaction overPurchase = new FruitTransaction();
        overPurchase.setOperation(Operation.PURCHASE);
        overPurchase.setFruit("apple");
        overPurchase.setQuantity(200);
        transactions.add(overPurchase);

        final FruitTransaction returnOp = new FruitTransaction();
        returnOp.setOperation(Operation.RETURN);
        returnOp.setFruit("apple");
        returnOp.setQuantity(10);
        transactions.add(returnOp);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> shopService.process(transactions));
        Assertions.assertEquals("Not enough fruit in storage for purchase: apple", exception.getMessage());

        final Map<String, Integer> storage = shopService.getStorage();
        Assertions.assertEquals(150, (int) storage.get("apple"));
    }
}
