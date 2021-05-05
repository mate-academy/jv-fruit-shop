package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class OperationIncreaseHandler implements OperationHandler {
    private final FruitDao fruitDaoDao;

    public OperationIncreaseHandler(FruitDao fruitDaoDao) {
        this.fruitDaoDao = fruitDaoDao;
    }

    @Override
    public int apply(int amount, Fruit key) {
        Optional<Integer> fruitQuantity = fruitDaoDao.get(key);
        return fruitQuantity.isPresent() ? fruitQuantity.get() + amount : amount;
    }
}
