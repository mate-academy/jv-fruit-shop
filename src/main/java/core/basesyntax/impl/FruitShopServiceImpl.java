package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;

public class FruitShopServiceImpl implements FruitShopService {

    @Override
    public void supplyFruit(FruitTransaction transaction) {
        if (Storage.getFruits().containsKey(transaction.getFruit())) {
            int quantity = Storage.getFruits().get(transaction.getFruit());
            Storage.getFruits().put(transaction.getFruit(),transaction.getQuantity() + quantity);
        }
        Storage.getFruits().put(transaction.getFruit(), transaction.getQuantity());
    }

    @Override
    public void purchaseFruit(FruitTransaction transaction) {
        int quantityOfFruit = Storage.getFruits().get(transaction.getFruit());
        if (quantityOfFruit < transaction.getQuantity()) {
            throw new RuntimeException("We don't have than much fruit to sell");
        }
        Storage.getFruits().put(transaction.getFruit(),
                quantityOfFruit - transaction.getQuantity());
    }

    @Override
    public void returnFruit(FruitTransaction transaction) {
        supplyFruit(transaction);
    }

    @Override
    public int balanceOfFruit(FruitTransaction transaction) {
        return Storage.getFruits().get(transaction.getFruit());
    }
}
