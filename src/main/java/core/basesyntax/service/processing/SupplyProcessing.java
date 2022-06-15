package core.basesyntax.service.processing;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;

public class SupplyProcessing extends FruitsDaoImpl implements OperationProcessing {
    private FruitsDao fruitsDao;

    public SupplyProcessing(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void doAction(String fruit, int amount) {
        fruitsDao.add(fruit, amount);
    }
}
