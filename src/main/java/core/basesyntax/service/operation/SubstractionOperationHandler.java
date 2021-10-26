package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;

public class SubstractionOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public SubstractionOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(String[] record) {
        int newQuantity = fruitDao.get(record[1]).getQuantity() - Integer.parseInt(record[2]);
        if (newQuantity < 0) {
            throw new RuntimeException("Invalid purchase. "
                    + "The store does not have the required quantity of fruits");
        }
        fruitDao.update(record[1], newQuantity);
    }
}
