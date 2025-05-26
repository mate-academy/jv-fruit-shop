package core.basesyntax.service;

import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.db.Storage;
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
            if (fruit.getOperation() == FruitOperation.Operation.BALANCE) {
                if (fruitOperationDao.get(fruit.getFruit()).isPresent()) {
                    throw new IllegalArgumentException("Fruit already exists in store: "
                            + fruit.getFruit());
                }
                fruitOperationDao.add(fruit);
                Storage.SHOP_STORE.put(fruit.getFruit(), fruit);
                continue;
            }

            Optional<FruitOperation> currentFruitOpt = fruitOperationDao.get(fruitName);
            if (currentFruitOpt.isEmpty()) {
                throw new IllegalArgumentException("Fruit not found in store: " + fruitName);
            }

            FruitOperation currentFruit = currentFruitOpt.get();

            int newValueFrom = strategy.get(fruit.getOperation())
                    .getQuantityFromStore(currentFruit, fruit.getQuantity());

            currentFruit.setQuantity(newValueFrom);
            fruitOperationDao.update(currentFruit);

            Storage.SHOP_STORE.put(fruitName, currentFruit);
        }
    }
}
