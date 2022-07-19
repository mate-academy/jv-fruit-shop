package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        Fruit fruit = fruitDao.get(transaction.getFruitName());
        int newQuantity = fruit.getQuantity() - transaction.getQuantity();
        fruit.setQuantity(newQuantity);
        fruitDao.update(fruit);
    }
}
