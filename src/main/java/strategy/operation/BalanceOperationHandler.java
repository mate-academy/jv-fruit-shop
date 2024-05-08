package strategy.operation;

import java.util.Map;
import model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void execute(Map<String, Integer> fruitBalance, FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        fruitBalance.put(fruit, transaction.getQuantity());
    }
}
