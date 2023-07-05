package strategy;

import db.ShopStorage;
import model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction, ShopStorage fruitStorage);
}
