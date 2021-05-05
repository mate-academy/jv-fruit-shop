package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.exeptions.InvalidQuantityException;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class OperationDecreaseHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public OperationDecreaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public int apply(int quantity, Fruit key) {
        Optional<Integer> fruitQuantity = fruitDao.get(key);
        if (fruitQuantity.isPresent()
                && fruitQuantity.get() >= quantity
                && quantity > 0) {
            return fruitQuantity.get() - quantity;
        }
        throw new InvalidQuantityException("You can't buy more fruits than there is in storage ["
                + quantity + "]");
    }
}
