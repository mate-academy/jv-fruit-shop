package service.impl;

import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.List;
import model.FruitTransaction;
import service.FruitShopService;
import strategy.OperationStrategy;

public class FruitShopServiceImpl implements FruitShopService {
    private final StorageDao storageDao;
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy optionalStrategy) {
        this.operationStrategy = optionalStrategy;
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void processOperation(List<FruitTransaction> fruitTransactionList) {

        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            calculate(fruitTransaction);
        }
    }

    private void calculate(FruitTransaction fruitTransaction) {
        Integer oldAmount = storageDao.get(fruitTransaction.getFruit());
        Integer newAmount = operationStrategy.get(fruitTransaction)
                .operate(fruitTransaction.getQuantity(), oldAmount);
        storageDao.set(fruitTransaction.getFruit(), newAmount);
    }
}
