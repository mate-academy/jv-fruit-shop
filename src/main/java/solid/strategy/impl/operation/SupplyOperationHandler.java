package solid.strategy.impl.operation;

import solid.model.FruitTransaction;
import solid.strategy.OperationHandler;
import solid.strorage.FruitStorage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (FruitStorage.fruits.containsKey(transaction.getFruit())) {
            FruitStorage.fruits.put(transaction.getFruit(),
                    FruitStorage.fruits.get(transaction.getFruit())
                            + transaction.getQuantity());
        } else {
            FruitStorage.fruits.put(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
