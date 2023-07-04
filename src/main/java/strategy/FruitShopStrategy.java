package strategy;

import db.ShopStorage;
import model.FruitTransaction;

public interface FruitShopStrategy {
    void doActivity(FruitTransaction transaction, ShopStorage fruitStorage);
}
