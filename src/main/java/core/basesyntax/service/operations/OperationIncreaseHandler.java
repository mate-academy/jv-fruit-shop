package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.exeptions.InvalidQuantityException;
import core.basesyntax.model.Fruit;

public class OperationIncreaseHandler implements OperationHandler {
    private static final String ERROR_MESSAGE
            = "Invalid quantity";
    private final FruitDao fruitDao;

    public OperationIncreaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public int apply(int quantity, Fruit key) {
        if (quantity < 0) {
            throw new InvalidQuantityException(ERROR_MESSAGE + "[" + quantity + "]");
        }
        int fruitQuantity = fruitDao.get(key).orElse(0);
        return fruitQuantity + quantity;
    }
}
