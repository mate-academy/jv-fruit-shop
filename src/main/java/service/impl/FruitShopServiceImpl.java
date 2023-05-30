package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.FruitShopService;
import strategy.OperationStrategy;

import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    @Override
    public void processOperation(List<FruitTransaction> fruitTransactionList, OperationStrategy operationStrategy, Storage storage) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            Integer oldAmount = Storage.get(fruitTransaction.getFruit());
            Integer newAmount = operationStrategy.get(fruitTransaction)
                    .operate(fruitTransaction.getQuantity(), oldAmount);
            Storage.set(fruitTransaction.getFruit(),newAmount);
        }
    }
}
