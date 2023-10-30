package service.transaction.strategy.type;

import java.util.Map;
import model.FruitTransaction;

public interface TransactionHandler {
    void perform(Map<String, Integer> stock, FruitTransaction fruitTransaction);
}
