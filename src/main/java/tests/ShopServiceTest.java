package tests;

import core.basesyntax.strategy.BalanceOperation;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopServiceTest {
    private ShopService shopService;
    private List<FruitTransaction> transactions;

    @BeforeEach
    public void setUp() {
        final Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(Operation.RETURN, new ReturnOperation());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperation());
        final OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        shopService = new ShopServiceImpl(operationStrategy);
        transactions = new ArrayList<>();
    }

    @Test
    public void test_balance_operation() {
        final FruitTransaction balance = new FruitTransaction();
        balance.setOperation(Operation.BALANCE);
        balance.setFruit("banana");
        balance.setQuantity(100);
        transactions.add(balance);

        shopService.process(transactions);
        final Map<String, Integer> storage = shopService.getStorage();

        assertEquals(100, (int) storage.get("banana"));
    }

    @Test
    public void test_supply_operation() {
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

        assertEquals(150, (int) storage.get("banana"));
    }

    @Test
    public void test_supply_new_fruit() {
        final FruitTransaction supply = new FruitTransaction();
        supply.setOperation(Operation.SUPPLY);
        supply.setFruit("apple");
        supply.setQuantity(30);
        transactions.add(supply);

        shopService.process(transactions);
        final Map<String, Integer> storage = shopService.getStorage();

        assertEquals(30, (int) storage.get("apple"));
    }

    @Test
    public void test_supply_negative_quantity() {
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

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> shopService.process(transactions));
        assertEquals("Invalid quantity: -20", exception.getMessage());
    }

    @Test
    public void test_supply_operation_with_no_balance() {
        final FruitTransaction supply = new FruitTransaction();
        supply.setOperation(Operation.SUPPLY);
        supply.setFruit("banana");
        supply.setQuantity(50);
        transactions.add(supply);

        shopService.process(transactions);
        final Map<String, Integer> storage = shopService.getStorage();

        assertEquals(50, (int) storage.get("banana"));
    }

    @Test
    public void test_combined_operations() {
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

        assertEquals(120, (int) storage.get("banana"));
    }

    @Test
    public void test_multiple_balance_operations() {
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

        assertEquals(150, (int) storage.get("apple"));
        assertEquals(100, (int) storage.get("banana"));
    }

    @Test
    public void test_balance_operation_negative_quantity() {
        final FruitTransaction balance = new FruitTransaction();
        balance.setOperation(Operation.BALANCE);
        balance.setFruit("banana");
        balance.setQuantity(-50);
        transactions.add(balance);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> shopService.process(transactions));
        assertEquals("Balance cannot be negative", exception.getMessage());
    }

    @Test
    public void test_balance_and_supply_operations_combined() {
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

        assertEquals(150, (int) storage.get("banana"));
    }

    @Test
    public void test_multiple_operations_for_same_fruit() {
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

        assertEquals(120, (int) storage.get("banana"));
    }

    @Test
    public void test_purchase_more_than_available() {
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

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> shopService.process(transactions));
        assertEquals("Not enough fruit in storage for purchase: banana", exception.getMessage());
    }

    @Test
    public void test_purchase_fruit_not_in_storage() {
        transactions.clear();

        final FruitTransaction purchase = new FruitTransaction();
        purchase.setOperation(Operation.PURCHASE);
        purchase.setFruit("orange");
        purchase.setQuantity(30);
        transactions.add(purchase);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> shopService.process(transactions));
        assertEquals("Not enough fruit in storage for purchase: orange", exception.getMessage());
    }

    @Test
    public void test_combined_operations_with_invalid_transactions() {
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

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> shopService.process(transactions));
        assertEquals("Invalid quantity: -50", exception.getMessage());

        final Map<String, Integer> storage = shopService.getStorage();
        assertEquals(100, (int) storage.get("banana"));
    }

    @Test
    public void test_combined_operations_with_unknown_operation() {
        final FruitTransaction balance = new FruitTransaction();
        balance.setOperation(Operation.BALANCE);
        balance.setFruit("banana");
        balance.setQuantity(100);
        transactions.add(balance);

        final FruitTransaction unknownOperation = new FruitTransaction();
        unknownOperation.setOperation(null);
        unknownOperation.setFruit("banana");
        unknownOperation.setQuantity(50);
        transactions.add(unknownOperation);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> shopService.process(transactions));
        assertEquals("Unknown operation: null", exception.getMessage());

        final Map<String, Integer> storage = shopService.getStorage();
        assertEquals(100, (int) storage.get("banana"));
    }

    @Test
    public void test_various_operations() {
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

        // Проверка на выброс исключения
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> shopService.process(transactions));
        assertEquals("Not enough fruit in storage for purchase: apple", exception.getMessage());

        // Проверка состояния хранилища
        final Map<String, Integer> storage = shopService.getStorage();
        assertEquals(150, (int) storage.get("apple")); // Ожидаемое значение должно быть 150
    }

}
