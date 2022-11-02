package Operations;

import DAO.DAOFruit;
import core.basesyntax.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
        private final DAOFruit fruitDao;

    public PurchaseOperation(DAOFruit fruitDao) {
            this.fruitDao = fruitDao;
        }

    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int amount = fruitDao.getAmountOfFruit(fruit);
        int purchaseAmount = transaction.getAmount();
        if (purchaseAmount <= amount) {
            fruitDao.addFruits(fruit, amount - purchaseAmount);
        } else {
            throw new RuntimeException();
        }
    }
}
