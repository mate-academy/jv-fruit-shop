package service.operation;

import dao.FruitDao;
import exception.InvalidDataException;
import model.Fruit;

public class PurchaseOperation implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public Fruit operate(Fruit fruit) {
        if (fruitDao.get(fruit).getQuantity() < fruit.getQuantity()) {
            throw new InvalidDataException("Storage doesn't have required amount of "
                    + fruit.getName());
        }
        fruitDao.get(fruit).setQuantity(fruitDao.get(fruit).getQuantity() - fruit.getQuantity());
        return fruitDao.get(fruit);
    }
}
