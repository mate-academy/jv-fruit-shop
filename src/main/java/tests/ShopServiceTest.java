package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import core.basesyntax.BalanceOperation;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void test_purchase_operation() {
        final FruitTransaction balance = new FruitTransaction();
        balance.setOperation(Operation.BALANCE);
        balance.setFruit("banana");
        balance.setQuantity(100);
        transactions.add(balance);

        final FruitTransaction purchase = new FruitTransaction();
        purchase.setOperation(Operation.PURCHASE);
        purchase.setFruit("banana");
        purchase.setQuantity(30);
        transactions.add(purchase);

        shopService.process(transactions);
        final Map<String, Integer> storage = shopService.getStorage();

        assertEquals(70, (int) storage.get("banana"));
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
}
