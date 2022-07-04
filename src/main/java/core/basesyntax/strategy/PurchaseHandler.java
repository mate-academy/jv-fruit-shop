package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import java.util.Optional;

public class PurchaseHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruit) {
        Optional<Integer> balance = fruitDao.get(fruit.getName());
        fruitDao.add(fruit.getName(), balance.orElse(0) - fruit.getAmount());
    }
}
