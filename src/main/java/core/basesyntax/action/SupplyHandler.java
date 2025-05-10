package core.basesyntax.action;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.implementation.FruitDaoImpl;

public class SupplyHandler implements ActionHandler {
    private final FruitDao fruitDao;

    public SupplyHandler() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public int performAction(String fruitName, int amount) {
        return fruitDao.get(fruitName) + amount;
    }
}
