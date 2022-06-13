package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.OperationHandler;
import service.OperationStrategy;
import service.ShopService;
import service.StorageService;

public class ShopServiceImplementation implements ShopService {
    private final StorageService storageService;
    private final OperationStrategy operationStrategy;

    public ShopServiceImplementation(StorageService storageService,
                                     OperationStrategy operationStrategy) {
        this.storageService = storageService;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void fill(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy
                    .getOperationHandler(transaction.getOperation());
            operationHandler.doTransaction(transaction);
        }
    }

    @Override
    public List<String[]> doReport() {
        List<String[]> list = storageService.getBalance();
        list.add(0, new String[]{"fruit", "quantity"});
        return list;
    }
}
