package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;

public class AdditionOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public AdditionOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(String[] record) {
        int newQuantity = Integer.parseInt(record[2]) + fruitDao.get(record[1]).getQuantity();
        fruitDao.update(record[1], newQuantity);
    }
}
