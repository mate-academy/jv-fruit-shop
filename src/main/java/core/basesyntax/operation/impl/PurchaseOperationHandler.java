package core.basesyntax.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.service.FruitService;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitDao fruitDao;
    private FruitService fruitService;

    public PurchaseOperationHandler(FruitDao fruitDao, FruitService fruitService) {
        this.fruitDao = fruitDao;
        this.fruitService = fruitService;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitTransaction fruitTransactionFromDB = fruitDao.get(fruitTransaction.getFruit());
        int updatedQuantity = fruitTransactionFromDB.getQuantity() - fruitTransaction.getQuantity();
        fruitTransactionFromDB.setQuantity(updatedQuantity);
        fruitService.add(fruitTransactionFromDB);
    }
}
