package core.basesyntax.service;

import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Optional;

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
                continue;
            }

            Optional<FruitOperation> currentFruitOpt = fruitOperationDao.get(fruit.getFruit());
            if (currentFruitOpt.isEmpty()) {
                System.err.println("Fruit not found in store, skipping: " + fruit.getFruit());
                continue;
            }

            FruitOperation currentFruit = currentFruitOpt.get();

            int newValueFrom = strategy.get(fruit.getOperation())
                    .getQuantityFromStore(currentFruit.getQuantity(), fruit.getQuantity());

            currentFruit.setQuantity(newValueFrom);
            fruitOperationDao.update(currentFruit);
        }
    }
}
