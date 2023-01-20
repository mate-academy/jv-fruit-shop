package dao;

import java.util.List;
import model.FruitTransaction;
import strategy.StoreOperationStrategy;

public interface FruitStoreDao {
    void addDataToStorage(List<FruitTransaction> dataList,
                          StoreOperationStrategy storeOperationStrategy);
}
