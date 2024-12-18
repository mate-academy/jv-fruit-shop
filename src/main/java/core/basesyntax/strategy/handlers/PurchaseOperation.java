package core.basesyntax.strategy.handlers;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        checkIfTransactionDataIsValid(fruit, quantity);

        if (!FruitStorage.fruits.containsKey(fruit)) {
            throw new RuntimeException(String.format("Fruit: '%s' is absent.", fruit));
        }
        if (FruitStorage.fruits.get(fruit) < quantity) {
            throw new RuntimeException(String.format("Fruit: '%s' is not enough.", fruit));
        }

        int newQuantity = FruitStorage.fruits.get(fruit) - quantity;
        FruitStorage.fruits.put(fruit, newQuantity);
    }
}
