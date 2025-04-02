package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> fruitStorage = new HashMap<>();

    public void addFruit(FruitTransaction fruitTransaction) {
        fruitStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }

    public Map<String, Integer> getFruitTransactionInfo() {
        return fruitStorage;
    }
}
