package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.IFruitDao;
import core.basesyntax.model.Fruit;

public class ReturnOperationHandler implements IOperationHandler {
    private final IFruitDao fruitDao = new FruitDao();

    @Override
    public void performOperation(String name, int quantity) {
        if (fruitDao.isFruitExist(name)) {
            int newQuantity = fruitDao.get(name).getQuantity() + quantity;
            Fruit newFruit = new Fruit(name, newQuantity);
            fruitDao.update(newFruit);
            return;
        }
        fruitDao.add(new Fruit(name, quantity));
    }
}
