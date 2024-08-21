package service.operation;

import dao.FruitDao;
import dao.FruitDaoImpl;

public class SupplyOperation implements OperationHandler {
    private FruitDao fruitDao;

    public SupplyOperation() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handle(String fruit, int quantity) {
        int balanceAfterSupply = fruitDao.getFruitBalance(fruit) + quantity;
        if (balanceAfterSupply >= 0) {
            fruitDao.updateBalanceOfFruit(fruit,balanceAfterSupply);
        } else {
            throw new RuntimeException("Quantity must be greater than zero."
                    + " But you provide: " + quantity);
        }
    }
}
