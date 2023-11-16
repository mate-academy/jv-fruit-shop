package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.exception.NoSuchOperationException;
import core.basesyntax.service.strategy.FruitResolver;
import java.util.Map;

public class FruitResolverImpl implements FruitResolver {

    private final Map<String, Fruit> fruitMap;

    public FruitResolverImpl(Map<String, Fruit> fruitMap) {
        this.fruitMap = fruitMap;

    }

    @Override
    public Fruit getFruit(String str) {
        Fruit fruit = fruitMap.get(str);
        if (fruit == null) {
            throw new NoSuchOperationException("No such fruit found");
        }
        return fruit;
    }
}
