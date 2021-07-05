package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.FruitImpl;

public class ReduceQuantityStrategy implements OperationStrategy {
    private final FruitDao fruitDao;

    public ReduceQuantityStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitDto transferAction) {
        FruitImpl fruit = new FruitImpl(transferAction.getName());
        int quantity = transferAction.getQuantity();
        int currentQuantity = fruitDao.getQuantity(fruit);
        if (currentQuantity < quantity) {
            throw new RuntimeException("There is less " + transferAction.getName()
                    + " in the warehouse than you would like to pick up: "
                    + currentQuantity
                    + " < "
                    + transferAction.getQuantity());
        }
        fruitDao.put(fruit, currentQuantity - quantity);
    }
}
