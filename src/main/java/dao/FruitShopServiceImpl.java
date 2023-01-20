package dao;

import java.util.List;
import model.FruitTransaction;
import strategy.StoreOperationStrategy;
import strategy.handler.OperationHandler;

public class FruitShopServiceImpl implements FruitShopService {
    private StoreOperationStrategy operationStrategy;

    public FruitShopServiceImpl(StoreOperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void addDataToStorage(List<FruitTransaction> dataList) {
        for (FruitTransaction transaction : dataList) {
            OperationHandler operation = operationStrategy
                    .getOperation(transaction.getStoreOperation());
            operation.handle(transaction);
        }
    }
}
