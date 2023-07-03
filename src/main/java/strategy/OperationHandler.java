package strategy;

import db.ShopStorage;
import model.FruitTransaction;

public interface OperationHandler {
    void handleOperation(FruitTransaction transaction, ShopStorage fruitStorage);
}
