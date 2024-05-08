package strategy;

import java.util.Map;
import model.FruitTransaction;
import strategy.operation.OperationHandler;

public interface OperationStrategy {

    OperationHandler handler(FruitTransaction fruitTransaction);

    Map<String, Integer> getFruitStatistic();

    void executeStrategy(FruitTransaction fruitTransaction);
}
