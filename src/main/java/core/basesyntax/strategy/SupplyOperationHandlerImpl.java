package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandlerImpl implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();
        try {
            if (FruitStorage.getFruit(fruitName).isPresent()) {
                String existingFruit = FruitStorage.getFruit(fruitName).get();
                if (existingFruit == null) {
                    FruitStorage.addFruit(fruitName, quantity);
                } else {
                    FruitStorage.setQuantity(existingFruit,
                            FruitStorage.getQuantity(existingFruit) + quantity);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
