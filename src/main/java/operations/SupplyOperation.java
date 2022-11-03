package operations;

import dao.DaoFruit;
import model.FruitTransaction;

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
