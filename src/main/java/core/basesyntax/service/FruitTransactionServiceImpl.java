package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private Map<String, Integer> fruitStorage = new HashMap<>();

    @Override
    public void handle(FruitTransaction transaction) {
        fruitStorage.put(transaction.getFruit(), transaction.getQuantity());
    }

    public Map<String, Integer> getFruitStorage() {
        return fruitStorage;
    }
}
