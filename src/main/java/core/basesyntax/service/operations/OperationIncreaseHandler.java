package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.exeptions.InvalidQuantityException;
import core.basesyntax.model.Fruit;

public class OperationIncreaseHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public OperationIncreaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public int apply(int quantity, Fruit key) {
        if (quantity < 0) {
            throw new InvalidQuantityException("Invalid quantity [" + quantity + "]");
        }
        int fruitQuantity = fruitDao.get(key).orElse(0);
        return fruitQuantity + quantity;
    }
}
