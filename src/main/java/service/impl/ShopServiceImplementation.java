package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.OperationService;
import service.ShopService;
import service.StorageService;
import strategy.OperationHandler;

public class ShopServiceImplementation implements ShopService {
    private final StorageService storageService;
    private final OperationHandler handler;

    public ShopServiceImplementation(StorageService storageService, OperationHandler handler) {
        this.storageService = storageService;
        this.handler = handler;
    }

    @Override
    public void fill(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationService operationService = handler
                    .getOperationServiceByTransaction(transaction);
            operationService.doTransaction(transaction);
        }
    }

    @Override
    public List<String[]> doReport() {
        List<String[]> list = storageService.getBalance();
        list.add(0, new String[]{"fruit", "quantity"});
        return list;
    }
}
