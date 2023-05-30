package service;

import db.Storage;
import java.util.List;
import model.FruitTransaction;
import strategy.OperationStrategy;

public interface FruitShopService {
    void processOperation(List<FruitTransaction> fruitTransactionList,
                          OperationStrategy operationStrategy,
                          Storage storage);
}
