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
              FruitTransaction existingFruit = FruitStorage.getFruit(fruitName).get();
            if (existingFruit == null) {
              FruitStorage.addFruit(new FruitTransaction(fruitName, quantity));
            } else {
                existingFruit.setQuantity(existingFruit.getQuantity() + quantity);
            }
               }
            }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
