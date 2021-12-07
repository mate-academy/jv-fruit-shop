package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;

public class IncreaseQuantityStrategy implements OperationStrategy {
    private final FruitDao fruitDao;

    public IncreaseQuantityStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitDto transferAction) {
        Fruit fruit = new Fruit(transferAction.getName());
        fruitDao.put(fruit, fruitDao.get(fruit) + transferAction.getQuantity());
    }
}
