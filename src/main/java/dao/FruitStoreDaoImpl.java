package dao;

import java.util.List;
import model.FruitTransaction;
import strategy.StoreOperationStrategy;
import strategy.handler.OperationHandler;

public class FruitStoreDaoImpl implements FruitStoreDao {
    @Override
    public void addDataToStorage(List<FruitTransaction> dataList,
                                 StoreOperationStrategy operationStrategy) {
        for (FruitTransaction transaction : dataList) {
            OperationHandler operation = operationStrategy
                    .getOperation(transaction.getStoreOperation());
            operation.handle(transaction);
        }
    }
}
