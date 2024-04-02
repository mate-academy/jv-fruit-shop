package service.Handler;

import model.FruitTransaction;
import java.util.Map;

public interface OperationHandler {
    void apply(FruitTransaction fruitTransaction,
               Map<String, Integer> fruitBalance);
}
