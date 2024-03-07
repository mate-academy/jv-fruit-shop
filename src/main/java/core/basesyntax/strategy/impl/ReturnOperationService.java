package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.exception.InsufficientFruitsException;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationService;

public class ReturnOperationService implements OperationService {
    private final FruitDao fruitDao;

    public ReturnOperationService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruitName, int quantity) {
        Fruit fruit = fruitDao.get(fruitName);
        if (fruit.getSold() >= quantity) {
            int newQuantity = fruit.getQuantity() + quantity;
            fruit.setQuantity(newQuantity);
            fruit.setSold(fruit.getSold() - quantity);
            fruitDao.update(fruit);
        } else {
            throw new InsufficientFruitsException("Not enough fruits were sold to "
                    + "fulfill the request");
        }
    }
}
