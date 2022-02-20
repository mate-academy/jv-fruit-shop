package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.operation.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(String[] record) {
        String fruitName = record[1];
        int quantity = Integer.parseInt(record[2]);
        if (!(fruitName.equals("apple") || fruitName.equals("banana"))) {
            throw new RuntimeException("Invalid fruit " + fruitName);
        }
        int newQuantity = quantity + fruitDao.get(fruitName).getQuantity();
        fruitDao.update(fruitName, newQuantity);
    }
}
