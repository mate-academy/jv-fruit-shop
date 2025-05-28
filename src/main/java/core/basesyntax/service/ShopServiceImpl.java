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
            String fruitName = fruit.getFruit();

            Optional<FruitOperation> currentFruitOpt = fruitOperationDao.get(fruitName);
            FruitOperation currentFruit = currentFruitOpt.orElse(fruit);

            int newValueFrom = strategy.get(fruit.getOperation())
                    .getQuantityFromStore(currentFruit, fruit.getQuantity());

            currentFruit.setQuantity(newValueFrom);

            if (currentFruitOpt.isEmpty()) {
                fruitOperationDao.add(currentFruit);
            } else {
                fruitOperationDao.update(currentFruit);
            }
        }
    }
}
