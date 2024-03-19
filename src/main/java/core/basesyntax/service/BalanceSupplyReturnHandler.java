package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceSupplyReturnHandler implements OperationHandler {
    private final Map<String, Integer> fruitStore;

    public BalanceSupplyReturnHandler(Map<String, Integer> fruitStore) {
        this.fruitStore = fruitStore;
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        switch (transaction.getOperation()) {
            case BALANCE:
            case SUPPLY:
                fruitStore.put(fruit, fruitStore.getOrDefault(fruit, 0) + quantity);
                break;
            case RETURN:
                Integer currentQuantity = fruitStore.get(fruit);
                if (currentQuantity == null || currentQuantity < quantity) {
                    throw new RuntimeException("Not enough " + fruit + " in the store to return");
                }
                fruitStore.put(fruit, currentQuantity - quantity);
                break;
            default:
                throw new RuntimeException("Invalid operation: " + transaction.getOperation());
        }
    }
}
