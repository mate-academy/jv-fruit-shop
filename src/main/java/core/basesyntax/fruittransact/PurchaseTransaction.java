package core.basesyntax.fruittransact;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class PurchaseTransaction implements FruitTransaction {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void handle(String name, int amount) {
        fruitDao.remove(name, amount);
    }
}
