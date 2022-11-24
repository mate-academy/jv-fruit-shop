package core.basesyntax.service.imp;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operations;
import core.basesyntax.service.ChangeFruitQuantityService;
import core.basesyntax.service.CounterService;
import core.basesyntax.strategy.FruitServiceStrategy;
import java.util.List;

public class CountingServiceImpl implements CounterService {
    @Override
    public void countFruits(List<FruitTransaction> transactionList) {
        for (int i = 0; i < transactionList.size(); i++) {
            String fruit = transactionList.get(i).getFruit();
            int quantity = transactionList.get(i).getQuantity();
            Operations operation = transactionList.get(i).getOperation();
            FruitServiceStrategy fruitServiceStrategy = new FruitServiceStrategy();
            ChangeFruitQuantityService changeFruitQuantityService = fruitServiceStrategy
                    .chooseFruitService(operation);
            changeFruitQuantityService.calculateFruits(fruit,quantity);
        }
    }
}
