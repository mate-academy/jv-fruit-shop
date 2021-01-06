package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class FruitServiceImplTest {
    private Map<Operation, OperationStrategy> operationOperationStrategyMap = new HashMap<>();

    @Test
    public void correctFruitServiceImnl() {
        Fruit banana = new Fruit();
        Fruit apple = new Fruit();
        banana.setName("banana");
        apple.setName("apple");
        Storage.fruits.put(banana, 30);
        Storage.fruits.put(apple, 20);
        FruitServiceImpl service = new FruitServiceImpl(operationOperationStrategyMap);
        Map<Fruit, Integer> map = service.getFruitReport();
        Assert.assertEquals(map.size(), Storage.fruits.size());
        Assert.assertEquals(map.get(banana), Storage.fruits.get(banana));
        Assert.assertEquals(map.get(apple), Storage.fruits.get(apple));
    }
}
