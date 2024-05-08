package strategy.operation;

import java.util.Map;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void execute(Map<String, Integer> fruitBalance, FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        fruitBalance.put(fruit, fruitBalance.getOrDefault(fruit, 0) - transaction.getQuantity());
    }
}
