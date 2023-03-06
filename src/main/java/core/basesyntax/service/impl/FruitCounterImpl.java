package core.basesyntax.service.impl;

import core.basesyntax.db.FruitsTransactions;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitCounter;
import core.basesyntax.strategy.StrategyOptions;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitCounterImpl implements FruitCounter {
    private StrategyOptions strategyOptions;

    public FruitCounterImpl(StrategyOptions strategyOptions) {
        this.strategyOptions = strategyOptions;
    }

    @Override
    public Fruit[] countReport() {
        Map<String, List<FruitTransaction>> collect = FruitsTransactions.Storage
                .stream().collect(Collectors.groupingBy(FruitTransaction::getFruit));
        Fruit[] fruits = new Fruit[collect.size()];
        int index = 0;
        for (Map.Entry<String, List<FruitTransaction>> entry: collect.entrySet()) {
            fruits[index] = new Fruit(entry.getKey(), 0);
            for (FruitTransaction element : entry.getValue()) {
                fruits[index] = strategyOptions.get(element.getOperation())
                        .getCount(element, fruits[index]);
            }
            index++;
        }
        return fruits;
    }
}
