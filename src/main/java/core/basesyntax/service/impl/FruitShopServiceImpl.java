package core.basesyntax.service.impl;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dao.StorageDaoImpl;
import core.basesyntax.model.FruitModel;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final StorageDao storageDao;
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void processData(List<FruitModel> fruitModel) {
        for (FruitModel fruitModel1 : fruitModel) {
            calculateTotalPrice(fruitModel1);
        }
    }

    private void calculateTotalPrice(FruitModel fruitModel) {
        Integer oldAmount = storageDao.get(fruitModel.getFruit());
        Integer newAmount = operationStrategy.getHandler(fruitModel)
                .operate(fruitModel.getQuantity(), oldAmount);
        storageDao.set(fruitModel.getFruit(), newAmount);
    }
}
