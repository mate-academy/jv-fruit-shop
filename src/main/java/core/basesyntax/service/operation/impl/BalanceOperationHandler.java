package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.operation.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public BalanceOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(String[] record) {
        String fruitName = record[1];
        int quantity = Integer.parseInt(record[2]);
        if (!(fruitName.equals("apple") || fruitName.equals("banana"))) {
            throw new RuntimeException("Invalid fruit " + fruitName);
        }
        fruitDao.add(fruitName,quantity);
    }
}
