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
import org.junit.Before;
import org.junit.Test;

public class TestFruitService {
    private static final Map<Operation, OperationStrategy> strategyMap = new HashMap<>();
    private static final List<TransactionDto> listTransaction = new ArrayList<>();
    private static Map<Fruit, Integer> storage;
    private static final FruitService fruitService = new FruitServiceImpl(strategyMap);

    @Before
    public void fillMapOperations() {
        strategyMap.put(Operation.BALANCE, new BalanceStrategy());
        strategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        strategyMap.put(Operation.RETURN, new ReturnStrategy());
        strategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
    }

    @Test
    public void checkMap() {
        Fruit banana = new Fruit("banana");
        listTransaction.add(new TransactionDto(Operation.BALANCE, banana, 20));
        listTransaction.add(new TransactionDto(Operation.RETURN, banana, 100));
        listTransaction.add(new TransactionDto(Operation.SUPPLY, banana, 100));
        listTransaction.add(new TransactionDto(Operation.PURCHASE, banana, 13));
        fruitService.applyOperation(listTransaction);
        storage = Storage.getFruits();
        Map<Fruit, Integer> expected = fruitService.getFruitReporter();
        assertEquals(storage.size(), expected.size(), "Size of must must be same");
        assertEquals(storage.keySet(), expected.keySet(), "Map keys must be equals");
        assertEquals(storage.entrySet(), expected.entrySet(), "Map must be equals");
    }

    @Test(expected = NullPointerException.class)
    public void notFillMap() {
        strategyMap.clear();
        Fruit banana = new Fruit("banana");
        listTransaction.add(new TransactionDto(Operation.BALANCE, banana, 20));
        listTransaction.add(new TransactionDto(Operation.RETURN, banana, 100));
        listTransaction.add(new TransactionDto(Operation.SUPPLY, banana, 100));
        listTransaction.add(new TransactionDto(Operation.PURCHASE, banana, 13));
        fruitService.applyOperation(listTransaction);
        storage = Storage.getFruits();
        Map<Fruit, Integer> expected = fruitService.getFruitReporter();
        assertEquals(storage.size(), expected.size(), "Size of must must be same");
        assertEquals(storage.keySet(), expected.keySet(), "Map keys must be equals");
        assertEquals(storage.entrySet(), expected.entrySet(), "Map must be equals");
    }
}
