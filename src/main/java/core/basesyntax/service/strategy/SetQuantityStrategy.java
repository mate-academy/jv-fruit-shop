package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;

public class SetQuantityStrategy implements OperationStrategy {
    private final FruitDao fruitDao;

    public SetQuantityStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitDto transferAction) {
        fruitDao.put(new Fruit(transferAction.getName()), transferAction.getQuantity());
    }
}
