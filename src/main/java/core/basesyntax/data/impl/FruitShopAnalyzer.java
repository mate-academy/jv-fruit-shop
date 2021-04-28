package core.basesyntax.data.impl;

import core.basesyntax.data.DataAnalyzer;
import core.basesyntax.dto.Dto;
import core.basesyntax.handlers.Operations;
import core.basesyntax.services.FruitsStrategy;
import core.basesyntax.storage.FruitDataBase;
import java.util.List;
import java.util.Map;

public class FruitShopAnalyzer implements DataAnalyzer {
    private final FruitDataBase fruitDataBase;
    private final Map<Operations, FruitsStrategy> fruitStrategies;

    public FruitShopAnalyzer(FruitDataBase fruitDataBase, Map<Operations,
            FruitsStrategy> fruitStrategies) {
        this.fruitDataBase = fruitDataBase;
        this.fruitStrategies = fruitStrategies;
    }

    @Override
    public void analyze(List<Dto> listWithFruits) {
        for (Dto fruit : listWithFruits) {
            fruitStrategies.get(Operations.getEnum(fruit.getOperation()))
                    .change(fruit, fruitDataBase);
        }
    }
}
