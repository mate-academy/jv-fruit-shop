package service.impl;

import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.List;
import model.FruitTransaction;
import service.FruitShopService;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class FruitShopServiceImpl implements FruitShopService {
    private final StorageDao storageDao;
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy optionalStrategy) {
        this.operationStrategy = optionalStrategy;
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler handler = operationStrategy.get(fruitTransaction.getOperation());
            if (handler != null && isValidQuantity(fruitTransaction.getQuantity())) {
                handler.operate(fruitTransaction, storageDao);
            }
        }
    }

    private boolean isValidQuantity(int quantity) {
        return quantity > 0;
    }
}
