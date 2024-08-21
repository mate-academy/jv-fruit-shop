package service.operation;

import dao.FruitDao;
import dao.FruitDaoImpl;

public class ReturnOperation implements OperationHandler {
    private FruitDao fruitDao;

    public ReturnOperation() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handle(String fruit, int quantity) {
        int balanceAfterReturn = fruitDao.getFruitBalance(fruit) + quantity;
        if (balanceAfterReturn >= 0) {
            fruitDao.updateBalanceOfFruit(fruit,balanceAfterReturn);
        } else {
            throw new RuntimeException("Quantity must be greater than zero."
                    + " But you provide: " + quantity);
        }
    }
}
