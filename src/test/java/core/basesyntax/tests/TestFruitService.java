package core.basesyntax.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFruitService {
    private static final Map<Operation, OperationStrategy> strategyMap = new HashMap<>();
    private static final List<TransactionDto> listTransaction = new ArrayList<>();
    private static final FruitService fruitService = new FruitServiceImpl(strategyMap);

    @Before
    public void fillMapOperations() {
        strategyMap.put(Operation.BALANCE, new BalanceStrategy());
        strategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        strategyMap.put(Operation.RETURN, new ReturnStrategy());
        strategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        Fruit banana = new Fruit("banana");
        listTransaction.add(new TransactionDto(Operation.BALANCE, banana, 20));
        listTransaction.add(new TransactionDto(Operation.RETURN, banana, 100));
        listTransaction.add(new TransactionDto(Operation.SUPPLY, banana, 100));
        listTransaction.add(new TransactionDto(Operation.PURCHASE, banana, 13));
    }

    @After
    public void clearData() {
        Storage.getFruits().clear();
    }

    @Test
    public void checkMap() {
        fruitService.applyOperation(listTransaction);
        Map<Fruit, Integer> storage = Storage.getFruits();
        Map<Fruit, Integer> expected = new HashMap<>();
        expected.put(new Fruit("banana"), 207);
        assertEquals(storage.size(), expected.size(), "Size of must must be same");
        assertEquals(storage.keySet(), expected.keySet(), "Map keys must be equals");
        assertEquals(storage.entrySet(), expected.entrySet(), "Map must be equals");
    }

    @Test
    public void checkGetFruitReport() {
        fruitService.applyOperation(listTransaction);
        Map<Fruit, Integer> storage = fruitService.getFruitReport();
        Map<Fruit, Integer> expected = new HashMap<>();
        expected.put(new Fruit("banana"), 207);
        assertEquals(storage.size(), expected.size(), "Size of must must be same");
        assertEquals(storage.keySet(), expected.keySet(), "Map keys must be equals");
        assertEquals(storage.entrySet(), expected.entrySet(), "Map must be equals");
    }
}
