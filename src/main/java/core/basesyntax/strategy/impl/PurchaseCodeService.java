package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.CodeService;

public class PurchaseCodeService implements CodeService {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void doOperation(FruitTransaction fruit) {
        FruitTransaction fruitTransaction = fruitDao.get(fruit.getFruit());
        fruitTransaction.setQuantity(fruitTransaction.getQuantity() - fruit.getQuantity());
        fruitDao.remove(fruit);
        fruitDao.add(fruitTransaction);
    }
}
