package service.impl;

import db.Storage;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ShopService;
import strategy.Operation;

public class ShopServiceImpl implements ShopService {
    private static final String Error = "No handler for operation: ";
    private final Map<FruitTransaction.Operation, strategy.Operation> operationMap;

    public ShopServiceImpl(Map<FruitTransaction.Operation, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public Map<String, Integer> processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction1 : transactions) {
            Operation handler = operationMap.get(transaction1.getOperation());
            if (handler != null) {
                handler.execute(transaction1.getFruit(), transaction1.getQuantity());
            } else {
                throw new RuntimeException(Error + transaction1.getOperation());
            }
        }
        return Storage.storage;
    }
}
