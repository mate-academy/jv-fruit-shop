package core.basesyntax.fruittransact;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;

public class SupplyService implements FruitService {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void handle(String name, int amount) {
        fruitDao.add(name, amount);
    }
}
