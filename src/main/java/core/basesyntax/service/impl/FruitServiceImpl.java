package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    @Override
    public void transactions(FruitDao fruitDao, List<FruitTransaction> fruits,
                             OperationStrategy operationStrategy) {
        List<String> fruitNames;
        fruitNames = fruits.stream()
                .map(FruitTransaction::getFruit)
                .distinct()
                .collect(Collectors.toList());

        for (String oneFruit : fruitNames) {
            fruitDao.add(oneFruit, 0);
        }

        Map<String, Integer> dataFromStorage = fruitDao.getFromStorage();
        for (var entry : dataFromStorage.entrySet()) {
            for (FruitTransaction fruit : fruits) {
                if (entry.getKey().equals(fruit.getFruit())) {
                    Integer value = entry.getValue();
                    entry.setValue(value + operationStrategy.get(fruit.getOperation())
                            .getQuantity(fruit.getQuantity()));
                }
            }
        }
    }
}
