package core.basesyntax.strategy.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImp;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitDao dataBase;

    public PurchaseOperationHandler() {
        this.dataBase = new FruitDaoImp();
    }

    @Override
    public boolean doOperation(FruitTransaction fruit) {
        String fruitName = fruit.getFruit();
        int fruitQuantity = fruit.getQuantity();
        dataBase.getStorage().put(fruitName, dataBase.get(fruitName) - fruitQuantity);
        return true;
    }
}
