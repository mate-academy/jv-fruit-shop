package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;

public class AdditionOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public AdditionOperationHandler(FruitDao fruitDao) {
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
