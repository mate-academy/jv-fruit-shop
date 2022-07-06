package core.basesyntax.strategy.handler;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

import java.util.Objects;


public class AdditionOperationHandler implements OperationHandler {
    FruitShopDao fruitShopDao;

    public AdditionOperationHandler(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        Fruit fruit;
        if(Objects.equals(fruitShopDao.get(fruitTransaction.getFruit()).getQuantity(), 0)) {
            fruit = new Fruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        } else {
            fruit = new Fruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity() + fruitShopDao.get(fruitTransaction.getFruit()).getQuantity());
        }
        fruitShopDao.add(fruit);
    }

    @Override
    public String toString() {
        return "AdditionOperationHandler";
    }
}
