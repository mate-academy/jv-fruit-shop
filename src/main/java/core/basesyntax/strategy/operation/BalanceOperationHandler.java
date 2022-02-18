package core.basesyntax.strategy.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void changeData(FruitTransaction fruitTransaction) {
        Fruit newFruit = new Fruit();
        newFruit.setFruitType(fruitTransaction.getFruitType());
        newFruit.setAmount(fruitTransaction.getAmount());
        fruitDao.add(newFruit);
    }
}
