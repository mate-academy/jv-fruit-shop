package core.basesyntax.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.service.FruitService;

public class ReturnOperationHandler implements OperationHandler {
    private FruitDao fruitDao;
    private FruitService fruitService;

    public ReturnOperationHandler(FruitDao fruitDao, FruitService fruitService) {
        this.fruitDao = fruitDao;
        this.fruitService = fruitService;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitTransaction fruitFromDataBase = fruitDao.get(fruitTransaction.getFruit());
        int amount = fruitFromDataBase.getQuantity() + fruitTransaction.getQuantity();
        fruitFromDataBase.setQuantity(amount);
        fruitService.add(fruitFromDataBase);
    }
}
