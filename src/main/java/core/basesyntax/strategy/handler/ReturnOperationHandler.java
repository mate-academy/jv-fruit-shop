package core.basesyntax.strategy.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImp;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private FruitDao dataBase;

    public ReturnOperationHandler() {
        this.dataBase = new FruitDaoImp();
    }

    @Override
    public boolean doOperation(FruitTransaction fruit) {
        String fruitName = fruit.getFruit();
        int fruitQuantity = fruit.getQuantity();
        dataBase.getStorage().put(fruitName, dataBase.get(fruitName) + fruitQuantity);
        return true;
    }
}
