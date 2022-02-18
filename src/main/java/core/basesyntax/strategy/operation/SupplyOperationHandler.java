package core.basesyntax.strategy.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void changeData(FruitTransaction fruitTransaction) {
        Fruit newFruit = new Fruit();
        Fruit fruitFromStorage = fruitDao.get(fruitTransaction.getFruitType());
        newFruit.setFruitType(fruitTransaction.getFruitType());
        newFruit.setAmount(fruitFromStorage.getAmount() + fruitTransaction.getAmount());
        fruitDao.update(newFruit);
    }
}
