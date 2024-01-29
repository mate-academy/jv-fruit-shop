package strategy;

import java.util.Map;

public class BalanceOperationStrategy implements OperationStrategy {

    @Override
    public void execute(String fruit, int quantity, Map<String, Integer> fruitQuantities) {
        fruitQuantities.put(fruit, quantity);
    }
}
