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
            throw new RuntimeException("Such fruit: " + fruit
                    + " is absent at fruitStorage!!!");
        }
        if (FruitStorage.fruits.get(fruit) < quantity) {
            throw new RuntimeException("Fruit: " + fruit + "=" + quantity
                    + " it is more than at fruitStorage!!! ");
        }

        int newQuantity = FruitStorage.fruits.get(fruit) - quantity;

        try {
            FruitStorage.fruits.put(fruit, newQuantity);
        } catch (Exception e) {
            throw new RuntimeException("Can't add data: "
                    + fruit + "=" + quantity + " to fruitStorage", e);
        }
    }
}
