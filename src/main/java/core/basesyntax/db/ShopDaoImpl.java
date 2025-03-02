package core.basesyntax.db;

import static core.basesyntax.storage.Storage.shop;

public class ShopDaoImpl implements ShopDao {

    @Override
    public void addFruit(String fruit, Integer quantity) {
        if (quantity < 0) {
            throw new RuntimeException("The quantity is negative");
        }
        shop.put(fruit, quantity);
    }

    @Override
    public void changeFruitQuantity(String fruit, Integer quantity) {
        if (!shop.containsKey(fruit) && quantity > 0) {
            throw new RuntimeException("There is no such fruit in shop");
        }
        if (shop.get(fruit) + quantity < 0) {
            throw new RuntimeException("Balance is too low for this purchase");
        }
        shop.put(fruit, shop.get(fruit) + quantity);
    }
}
