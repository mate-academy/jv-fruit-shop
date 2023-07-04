package strategy;

import db.ShopStorage;
import model.FruitTransaction;

public class BalanceStrategy implements FruitShopStrategy {
    @Override
    public void doActivity(FruitTransaction transaction, ShopStorage storage) {
        storage.updateQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
