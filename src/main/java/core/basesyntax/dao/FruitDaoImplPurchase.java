package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImplPurchase implements FruitDao {
    @Override
    public Fruit update(Fruit fruit, Integer amount) {
        if (!Storage.storage.containsKey(fruit)) {
            throw new RuntimeException("There is no such fruit in the shop: " + fruit);
        }
        Integer fruitsAmountInTheShop = Storage.storage.get(fruit);
        if (fruitsAmountInTheShop < amount) {
            throw new RuntimeException(String.format("Not enough fruits in the shop. "
                    + "There are %d but you asked %d of %s", fruitsAmountInTheShop, amount, fruit));
        }
        Storage.storage.put(fruit, fruitsAmountInTheShop - amount);
        return fruit;
    }
}
