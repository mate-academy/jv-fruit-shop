package service.operation;

import dao.FruitDao;

public class ReturnOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(String fruit, int quantity) {
        fruitDao.updateBalance(fruit, fruitDao.getBalance(fruit) + quantity);
    }
}
