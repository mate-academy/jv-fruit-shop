package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.TransferAction;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitImpl;

public class IncreaseQuantityStrategy implements OperationStrategy {
    @Override
    public void process(FruitDao fruitDao, TransferAction transferAction) {
        Fruit fruit = new FruitImpl(transferAction.getName());
        fruitDao.put(fruit, fruitDao.getQuantity(fruit) + transferAction.getQuantity());
    }
}
