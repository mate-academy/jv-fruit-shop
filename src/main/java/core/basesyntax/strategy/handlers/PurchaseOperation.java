package core.basesyntax.strategy.handlers;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Boolean executeOperation(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        if (isValidTransactionData(fruit, quantity)) {
            try {
                if (FruitStorage.fruits.containsKey(fruit)) {
                    if (FruitStorage.fruits.get(fruit) >= quantity) {
                        quantity = FruitStorage.fruits.get(fruit) - quantity;
                        FruitStorage.fruits.put(fruit, quantity);
                    } else {
                        throw new RuntimeException(fruit + " is not enough"
                                                   + " in fruitStorage for PURCHASE.");
                    }
                } else {
                    throw new RuntimeException("Such fruit: " + fruit
                                               + " is absent at fruitStorage!!!");
                }
            } catch (Exception e) {
                throw new RuntimeException("Can't add data: " + fruit + "="
                                           + quantity + " to fruitStorage", e);
            }
        } else {
            throw new RuntimeException("Not valid transactionData: " + transaction);
        }

        return FruitStorage.fruits.get(fruit) == quantity;
    }
}
