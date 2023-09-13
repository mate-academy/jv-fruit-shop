package core.basesyntax.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.service.FruitService;

public class SupplyOperationHandler implements OperationHandler {
    private FruitDao fruitDao;
    private FruitService fruitService;

    public SupplyOperationHandler(FruitDao fruitDao, FruitService fruitService) {
        this.fruitDao = fruitDao;
        this.fruitService = fruitService;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitTransaction fruitFromDataBase = fruitDao.get(fruitTransaction.getFruit());
        if (fruitFromDataBase == null) {
            fruitService.add(fruitTransaction);
        } else {
            int amount = fruitFromDataBase.getQuantity() + fruitTransaction.getQuantity();
            fruitFromDataBase.setQuantity(amount);
            fruitService.add(fruitFromDataBase);
        }
    }
}
