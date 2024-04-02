package service.handler;

import java.util.Map;
import model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction fruitTransaction,
               Map<String, Integer> fruitBalance);
}
