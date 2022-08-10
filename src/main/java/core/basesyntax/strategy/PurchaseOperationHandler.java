package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(String fruit, Integer quantity) {
        Integer newQuantity = fruitDao.getQuantity(fruit) - quantity;
        if (newQuantity < 0) {
            throw new RuntimeException("After purchase " + fruit + " quantity " + quantity
                    + " the balance is negative");
        }

        fruitDao.add(fruit, newQuantity);
    }
}
