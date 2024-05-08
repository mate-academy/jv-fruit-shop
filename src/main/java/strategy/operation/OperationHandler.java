package strategy.operation;

import java.util.Map;
import model.FruitTransaction;

public interface OperationHandler {
    void execute(Map<String, Integer> fruitBalance, FruitTransaction transaction);
}
