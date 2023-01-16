package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessorService;
import java.util.Map;

public class TranactionProcessorServiceImpl implements TransactionProcessorService {
    @Override
    public void process(FruitTransaction transaction, Map<String, Integer> fruits) {
        String fruit = transaction.getFruit();
        fruits.put(fruit, fruits.get(fruit) - transaction.getQuantity());
    }
}
