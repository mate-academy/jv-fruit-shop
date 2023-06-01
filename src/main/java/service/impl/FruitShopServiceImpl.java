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
<<<<<<<<< Temporary merge branch 1

    public FruitShopServiceImpl(OperationStrategy optionalStrategy) {
        this.operationStrategy = optionalStrategy;
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void processOperation(List<FruitTransaction> fruitTransactionList) {
=========
>>>>>>>>> Temporary merge branch 2

    public FruitShopServiceImpl(OperationStrategy optionalStrategy) {
        this.operationStrategy = optionalStrategy;
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
<<<<<<<<< Temporary merge branch 1
            calculate(fruitTransaction);
        }
    }

    private void calculate(FruitTransaction fruitTransaction) {
        Integer oldAmount = storageDao.get(fruitTransaction.getFruit());
        Integer newAmount = operationStrategy.get(fruitTransaction)
                .operate(fruitTransaction.getQuantity(), oldAmount);
        storageDao.set(fruitTransaction.getFruit(), newAmount);
=========
            OperationHandler handler = operationStrategy.get(fruitTransaction.getOperation());
            if (handler != null && isValidQuantity(fruitTransaction.getQuantity())) {
                handler.operate(fruitTransaction, storageDao);
            }
        }
    }

    private boolean isValidQuantity(int quantity) {
        return quantity > 0;
>>>>>>>>> Temporary merge branch 2
    }
}
