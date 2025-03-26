package service.impl;

import db.StorageService;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ShopService;
import strategy.Operation;

public class ShopServiceImpl implements ShopService {
    private static final String Error = "No handler for operation: ";
    private final StorageService storage;
    private final Map<FruitTransaction.Operation, strategy.Operation> operationMap;

    public ShopServiceImpl(StorageService storage,
            Map<FruitTransaction.Operation, Operation> operationMap) {
        this.storage = storage;
        this.operationMap = operationMap;
    }

    @Override
    public Map<String, Integer> processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction1 : transactions) {
            Operation operation = operationMap.get(transaction1.getOperation());
            String fruit = transaction1.getFruit();
            int quantity = transaction1.getQuantity();

            if (operation != null) {
                operation.execute(storage, fruit, quantity);
            } else {
                System.out.println(Error + transaction1.getOperation());
            }
        }
        return storage.getStorageCopy();
    }
}
