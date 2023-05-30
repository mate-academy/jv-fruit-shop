package service;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationStrategy;

import java.util.List;

public interface FruitShopService {
    void processOperation(List<FruitTransaction> fruitTransactionList, OperationStrategy operationStrategy,
                          Storage storage);
}
