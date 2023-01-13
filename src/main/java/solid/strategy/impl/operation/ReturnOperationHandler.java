package solid.strategy.impl.operation;

import java.util.Map;
import solid.model.FruitTransaction;
import solid.strategy.OperationHandler;
import solid.strorage.FruitStorage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        for (Map.Entry<String, Integer> fruit : FruitStorage.fruits.entrySet()) {
            if (fruit.getKey().equals(transaction.getFruit())) {
                fruit.setValue(fruit.getValue() + transaction.getQuantity());
            }
        }
    }
}
