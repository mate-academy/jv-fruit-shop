package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;

public class SubstractionOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public SubstractionOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(String[] record) {
        String fruitName = record[1];
        int quantity = Integer.parseInt(record[2]);
        if (!(fruitName.equals("apple") || fruitName.equals("banana"))) {
            throw new RuntimeException("Invalid fruit " + fruitName);
        }
        int newQuantity = fruitDao.get(fruitName).getQuantity() - quantity;
        fruitDao.update(fruitName, newQuantity);
    }
}
