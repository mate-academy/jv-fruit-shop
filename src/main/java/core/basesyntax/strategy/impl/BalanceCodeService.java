package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.CodeService;

public class BalanceCodeService implements CodeService {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void doOperation(FruitTransaction fruit) {
        if (fruit.getQuantity() < 0) {
            throw new RuntimeException("Fruits " + fruit.getFruit() + " less than 0");
        }
        if (fruitDao.getAll().containsKey(fruit.getFruit())) {
            int oldQuantity = fruitDao.get(fruit.getFruit());
            fruitDao.add(fruit.getFruit(), fruit.getQuantity() + oldQuantity);
        } else {
            fruitDao.add(fruit.getFruit(), fruit.getQuantity());
        }
    }
}
