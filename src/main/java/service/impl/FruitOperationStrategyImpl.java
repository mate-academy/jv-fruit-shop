package service.impl;

import dao.StorageDao;
import db.Storage;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitOperationStrategy;
import strategy.FruitsAmountHandler;

public class FruitOperationStrategyImpl implements FruitOperationStrategy {
    private StorageDao storageDao;
    private Map<FruitTransaction.Operation, FruitsAmountHandler> amountHandlerMap;

    public FruitOperationStrategyImpl(StorageDao storageDao, Map<FruitTransaction.Operation,
            FruitsAmountHandler> amountHandlerMap) {
        this.storageDao = storageDao;
        this.amountHandlerMap = amountHandlerMap;
    }

    @Override
    public void fillStorage(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruit: fruitTransactions) {
            if (Storage.report.containsKey(fruit.getFruit())) {
                amountHandlerMap.get(fruit.getOperation())
                        .updateAmount(fruit.getFruit(), fruit.getQuantity());
            } else {
                storageDao.update(fruit.getFruit(), fruit.getQuantity());
            }
        }
    }
}
