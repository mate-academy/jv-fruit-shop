package core.basesyntax.service;

import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private FruitOperationDao fruitOperationDao;
    private OperationStrategy strategy;

    public ShopServiceImpl(FruitOperationDao fruitOperationDao, OperationStrategy strategy) {
        this.fruitOperationDao = fruitOperationDao;
        this.strategy = strategy;
    }

    @Override
    public void changeQuantityStore(List<FruitOperation> fruits) {
        for (FruitOperation fruit : fruits) {
            if (fruit.getOperation() == FruitOperation.Operation.BALANCE) {
                fruitOperationDao.add(fruit);
            }
            FruitOperation currentFruit = fruitOperationDao.get(fruit.getFruit());
            int newValueFrom = strategy.get(fruit.getOperation())
                    .getQuantity(currentFruit.getQuantity(), fruit.getQuantity());
            currentFruit.setQuantity(newValueFrom);
            fruitOperationDao.update(currentFruit);
        }
    }
}
