package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class OperationIncreaseHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public OperationIncreaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public int apply(int quantity, Fruit key) {
        Optional<Integer> fruitQuantity = fruitDao.get(key);
        return fruitQuantity.isPresent() ? fruitQuantity.get() + quantity : quantity;
    }
}
