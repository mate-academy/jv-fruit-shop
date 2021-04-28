package core.basesyntax.data.impl;

import core.basesyntax.data.DataAnalyzer;
import core.basesyntax.dto.Dto;
import core.basesyntax.storage.FruitDataBase;
import core.basesyntax.strategy.FruitsStrategy;
import core.basesyntax.strategy.Operations;
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

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entrySet : fruitDataBase.getDataBaseCopy().entrySet()) {
            report.append(entrySet.getKey()).append(", ").append(entrySet.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
