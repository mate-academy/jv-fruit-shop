package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.IFruitDao;
import core.basesyntax.model.Fruit;

public class PurchaseOperationHandler implements IOperationHandler {
    private final IFruitDao fruitDao = new FruitDao();

    @Override
    public void performOperation(String name, int quantity) {
        if (fruitDao.isFruitExist(name)) {
            Fruit fruit = fruitDao.get(name);
            int newQuantity = fruit.getQuantity() - quantity;

            if (newQuantity < 0) {
                throw new RuntimeException("Not enough fruit " + name);
            }

            fruitDao.update(new Fruit(name, newQuantity));
            return;
        }
        throw new RuntimeException("There are not this type of fruit");
    }
}
