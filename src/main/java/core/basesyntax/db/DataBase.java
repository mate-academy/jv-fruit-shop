package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private final Map<String, Integer> fruitTransactionInfo = new HashMap<>();

    public void addFruitTransactionInfo(FruitTransaction fruitTransaction) {
        fruitTransactionInfo.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }

    public Map<String, Integer> getFruitTransactionInfo() {
        return fruitTransactionInfo;
    }
}
