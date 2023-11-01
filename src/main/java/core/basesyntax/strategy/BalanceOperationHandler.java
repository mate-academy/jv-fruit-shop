package core.basesyntax.strategy;

import core.basesyntax.Dao.FruitDao;
import core.basesyntax.Dao.FruitDaoImp;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private FruitDao dataBase;

    public BalanceOperationHandler() {
        this.dataBase = new FruitDaoImp();
    }

    @Override
    public boolean DoOperation(FruitTransaction fruit) {
        String fruitName = fruit.getFruit();
        int fruitQuantity = fruit.getQuantity();
        dataBase.getStorage().put(fruitName, fruitQuantity);
        return true;
    }
}
