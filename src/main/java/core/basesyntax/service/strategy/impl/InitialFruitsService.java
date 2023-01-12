package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessorService;
import java.util.Map;

public class InitialFruitsService implements TransactionProcessorService {
    public InitialFruitsService(FruitTransaction transaction, Map<String, Integer> fruits) {
        process(transaction, fruits);
    }

    @Override
    public void process(FruitTransaction transaction, Map<String, Integer> fruits) {
        fruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
