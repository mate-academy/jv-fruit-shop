package core.basesyntax.tests;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operations;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationWithFruits;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitsAdditionImpl;
import core.basesyntax.service.impl.FruitsReductionImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceImplTest {
    private static List<Transaction> expectedList;
    private static FruitService fruitService;

    @BeforeClass
    public static void beforeClass() {
        expectedList = new ArrayList<>();
        expectedList.add(new Transaction(Operations.BALANCE, new Fruit("banana"), 20));
        expectedList.add(new Transaction(Operations.BALANCE, new Fruit("kiwi"), 100));
        expectedList.add(new Transaction(Operations.SUPPLY, new Fruit("banana"), 100));
        expectedList.add(new Transaction(Operations.PURCHASE, new Fruit("banana"), 13));
        expectedList.add(new Transaction(Operations.RETURN, new Fruit("apple"), 10));
        expectedList.add(new Transaction(Operations.PURCHASE, new Fruit("kiwi"), 100));
        expectedList.add(new Transaction(Operations.PURCHASE, new Fruit("banana"), 26));
        expectedList.add(new Transaction(Operations.SUPPLY, new Fruit("apple"), 50));
        Map<Operations, OperationWithFruits> fruitsMap = new HashMap<>();
        fruitsMap.put(Operations.BALANCE, new FruitsAdditionImpl());
        fruitsMap.put(Operations.SUPPLY, new FruitsAdditionImpl());
        fruitsMap.put(Operations.PURCHASE, new FruitsReductionImpl());
        fruitsMap.put(Operations.RETURN, new FruitsAdditionImpl());
        fruitService = new FruitServiceImpl(fruitsMap);
    }

    @Test
    public void applyingStrategy() {
        fruitService.putDataToStorage(expectedList);
        assertEquals(81, Storage.storage.get(new Fruit("banana")).intValue());
        assertEquals(0, Storage.storage.get(new Fruit("kiwi")).intValue());
        assertEquals(60, Storage.storage.get(new Fruit("apple")).intValue());
    }

    @Test
    public void gettingFromStorage() {
        fruitService.putDataToStorage(expectedList);
        assertEquals(3, Storage.storage.size());
        assertEquals(0, Storage.storage.get(new Fruit("kiwi")).intValue());
    }

    @After
    public void clearStorage() {
        Storage.storage.clear();
    }
}
