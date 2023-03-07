package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitDto;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitCounter;
import core.basesyntax.strategy.StrategyOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitCounterImpl implements FruitCounter {
    private StrategyOptions strategyOptions;

    public FruitCounterImpl(StrategyOptions strategyOptions) {
        this.strategyOptions = strategyOptions;
    }

    @Override
    public List<FruitDto> countReport() {
        Map<String, List<FruitTransaction>> collect = Storage.storage
                .stream().collect(Collectors.groupingBy(FruitTransaction::getFruit));
        List<FruitDto> fruits = new ArrayList<>();
        for (Map.Entry<String, List<FruitTransaction>> entry: collect.entrySet()) {
            FruitDto fruitDto = new FruitDto(entry.getKey(), 0);
            for (FruitTransaction element : entry.getValue()) {
                strategyOptions.get(element.getOperation())
                        .applyAction(element, fruitDto);
            }
            fruits.add(fruitDto);
        }
        return fruits;
    }
}
