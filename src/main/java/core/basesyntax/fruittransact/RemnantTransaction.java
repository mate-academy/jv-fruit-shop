package core.basesyntax.fruittransact;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class RemnantTransaction implements FruitTransaction {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void transact(String name, int amount) {
        fruitDao.set(name, amount);
    }
}
