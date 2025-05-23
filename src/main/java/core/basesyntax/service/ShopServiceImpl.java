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
            if (fruit.getOperation() == FruitOperation.Operation.BALANCE) {
                fruitOperationDao.add(fruit);
                Storage.SHOP_STORE.add(fruit);
                continue;
            }

            Optional<FruitOperation> currentFruitOpt = fruitOperationDao.get(fruit.getFruit());
            if (currentFruitOpt.isEmpty()) {
                throw new IllegalArgumentException("Fruit not found in store: " + fruit.getFruit());
            }

            FruitOperation currentFruit = currentFruitOpt.get();

            int newValueFrom = strategy.get(fruit.getOperation())
                    .getQuantityFromStore(currentFruit, fruit.getQuantity());

            currentFruit.setQuantity(newValueFrom);
            fruitOperationDao.update(currentFruit);

            for (int i = 0; i < Storage.SHOP_STORE.size(); i++) {
                if (Storage.SHOP_STORE.get(i).getFruit().equals(currentFruit.getFruit())) {
                    Storage.SHOP_STORE.set(i, currentFruit);
                    break;
                }
            }
        }
    }
}
