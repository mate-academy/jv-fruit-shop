package service.operation;

import dao.FruitDao;
import exception.ValidationException;

public class PurchaseOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(String fruit, int quantity) {
        int balanceAfterPurchase = fruitDao.getBalance(fruit) - quantity;
        if (balanceAfterPurchase < 0) {
            throw new ValidationException(String.format("You wanted to buy %d %ss but available "
                    + "only %d %ss", quantity, fruit, fruitDao.getBalance(fruit), fruit));
        }
        fruitDao.updateBalance(fruit, balanceAfterPurchase);
    }
}
