package core.basesyntax.strategy.handlers;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        checkIfTransactionDataIsValid(fruit, quantity);

        if (FruitStorage.fruits.containsKey(fruit)) {
            int newQuantity = FruitStorage.fruits.get(fruit) + quantity;
            FruitStorage.fruits.put(fruit, newQuantity);
        } else {
            FruitStorage.fruits.put(fruit, quantity);
        }
    }
}
