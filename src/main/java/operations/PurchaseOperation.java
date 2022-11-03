package operations;

import dao.DaoFruit;
import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private final DaoFruit fruitDao;

    public PurchaseOperation(DaoFruit fruitDao) {
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
            throw new RuntimeException("Can`t add fruits");
        }
    }
}
