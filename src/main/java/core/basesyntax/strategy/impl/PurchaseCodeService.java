package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.CodeService;

public class PurchaseCodeService implements CodeService {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void doOperation(FruitTransaction fruit) {
        int oldQuantity = fruitDao.get(fruit.getFruit());
        fruitDao.add(fruit.getFruit(), oldQuantity - fruit.getQuantity());
    }
}
