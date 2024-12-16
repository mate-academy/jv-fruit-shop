package core.basesyntax.strategy.handlers;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public Boolean executeOperation(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        if (isValidTransactionData(fruit, quantity)) {
            try {
                if (FruitStorage.fruits.containsKey(fruit)) {
                    quantity += FruitStorage.fruits.get(fruit);
                    FruitStorage.fruits.put(fruit, quantity);
                } else {
                    FruitStorage.fruits.put(fruit, quantity);
                }
            } catch (Exception e) {
                throw new RuntimeException("Can't add data: " + fruit
                                           + "=" + quantity + " to fruitStorage", e);
            }
        } else {
            throw new RuntimeException("Not valid transactionData: " + transaction);
        }

        return FruitStorage.fruits.get(fruit) == quantity;
    }
}
