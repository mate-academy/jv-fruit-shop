package service.impl;

import db.FruitsStorage;
import java.util.List;
import model.FruitTransaction;
import service.FruitDalyTransactionsHandler;
import strategy.DalyOperationStrategy;

public class FruitDalyTransactionsHandlerImpl implements FruitDalyTransactionsHandler {

    @Override
    public FruitsStorage getFruitBalance(List<FruitTransaction> fruitTransactions,
                                DalyOperationStrategy strategy) {
        int fruitAmount = 0;
        FruitsStorage fruitsStorage = new FruitsStorage();

        for (var fruit : fruitTransactions) {
            if (strategy.getOperation(fruit.getOperationType()).getOperation() == 0) {
                fruitsStorage.addFruitsStorage(fruit.getName(),
                        fruit.getQuantity());
            } else {
                for (var dbEntry : fruitsStorage.getFruitsStorage().entrySet()) {
                    if (dbEntry.getKey().equals(fruit.getName())) {
                        fruitAmount = dbEntry.getValue();
                        break;
                    }
                }
                fruitAmount = fruitAmount + fruit.getQuantity()
                        * strategy.getOperation(fruit.getOperationType()).getOperation();
                fruitsStorage.addFruitsStorage(fruit.getName(),
                        fruitAmount);
                fruitAmount = 0;
            }
        }
        return fruitsStorage;
    }
}
