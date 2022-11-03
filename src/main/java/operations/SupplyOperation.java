package operations;

import core.basesyntax.FruitTransaction;
import dao.DaoFruit;

public class SupplyOperation implements OperationHandler {
    private final DaoFruit fruitDao;

    public SupplyOperation(DaoFruit fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
        public void handle(FruitTransaction fruitTransaction) {
        int amountFromStorage = fruitDao.getAmountOfFruit(fruitTransaction.getFruit());
        fruitDao.addFruits(fruitTransaction.getFruit(),
                    amountFromStorage + fruitTransaction.getAmount());
    }
}
