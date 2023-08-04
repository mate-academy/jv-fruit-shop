package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandlerImpl implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();
        try {
            if (FruitStorage.isFruitPresent(fruitName)) {
                FruitStorage.setQuantity(fruitName,
                        FruitStorage.getQuantity(fruitName) + quantity);
            } else {
                FruitStorage.addFruit(fruitName, quantity);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
