package strategy;

import java.util.Map;
import model.FruitTransaction;

public interface OperationHandler {
    void operate(Map<String, Integer> fruits, FruitTransaction transaction);
}
