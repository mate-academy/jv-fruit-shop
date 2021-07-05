package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.TransferAction;
import core.basesyntax.model.FruitImpl;

public class ReduceQuantityStrategy implements OperationStrategy {
    @Override
    public void process(FruitDao fruitDao, TransferAction transferAction) {
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
