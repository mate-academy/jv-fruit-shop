package core.basesyntax.strategy.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements DailyOperationHandler {
    private FruitDao fruitDao;

    public BalanceOperation(FruitDao fruitDao) {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void apply(FruitTransaction dailyTransaction) {
        Fruit fruit = new Fruit();
        fruit.setFruitName(dailyTransaction.getFruitName());
        fruit.setQuantity(dailyTransaction.getQuantity());
        fruitDao.add(fruit);
    }
}
