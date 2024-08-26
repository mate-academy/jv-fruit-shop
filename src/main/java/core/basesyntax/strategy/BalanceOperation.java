package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        String fruit = transaction.getFruit();
        int quantityToBalance = transaction.getQuantity();
        int newQuantity = quantityToBalance;
        if (newQuantity < 0) {
            throw new RuntimeException("Balance for "
                    + fruit + " cannot be negative.");
        }
        storage.put(fruit, newQuantity);
    }
}
