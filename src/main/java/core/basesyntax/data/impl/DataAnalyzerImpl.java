package core.basesyntax.data.impl;

import core.basesyntax.data.DataAnalyzer;
import core.basesyntax.dto.Dto;
import core.basesyntax.handlers.Operations;
import core.basesyntax.services.FruitsService;
import core.basesyntax.storage.FruitDataBase;
import java.util.List;
import java.util.Map;

public class DataAnalyzerImpl implements DataAnalyzer {
    @Override
    public void analyze(List<Dto> listWithFruits, Map<Operations, FruitsService> fruitStrategies,
                        FruitDataBase fruitDataBase) {
        for (Dto fruit : listWithFruits) {
            fruitStrategies.get(Operations.getEnum(fruit.getOperation()))
                    .change(fruit, fruitDataBase);
        }
    }
}
