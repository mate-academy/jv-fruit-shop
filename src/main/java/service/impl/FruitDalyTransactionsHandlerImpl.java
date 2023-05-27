package service.impl;

import db.FruitsStorage;
import java.util.List;
import model.FruitTransactionModel;
import service.FruitDalyTransactionsHandler;
import strategy.DalyOperationStrategy;

//this class calculate balance of fruits according to the strategy
// - received List<FruitTransactionModel> and DalyOperationStrategy
// - return an instance of FruitsStorage
public class FruitDalyTransactionsHandlerImpl implements FruitDalyTransactionsHandler {

    @Override
    public FruitsStorage getFruitBalance(List<FruitTransactionModel> fruitTransactionModels,
                                DalyOperationStrategy strategy) {
        int fruitAmount = 0;
        FruitsStorage fruitsStorage = new FruitsStorage();

        for (var fruit : fruitTransactionModels) {
            //if there is a balance operation - than just create new instance in the Map
            if (strategy.getOperation(fruit.getOperationType()) == 0) {
                fruitsStorage.addFruitsStorage(fruit.getName(),
                        fruit.getQuantity());
            } else { //if there are others operations - than calculate the quantity
                //find this type of fruit in the Map
                for (var dbEntry : fruitsStorage.getFruitsStorage().entrySet()) {
                    if (dbEntry.getKey().equals(fruit.getName())) {
                        fruitAmount = dbEntry.getValue();
                        break;
                    }
                }
                //calculate new amount according to the strategy
                fruitAmount = fruitAmount + fruit.getQuantity()
                        * strategy.getOperation(fruit.getOperationType());
                fruitsStorage.addFruitsStorage(fruit.getName(),
                        fruitAmount);
                fruitAmount = 0;
            }
        }
        return fruitsStorage;
    }
}
