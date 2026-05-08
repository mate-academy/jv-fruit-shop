package service.impl;

import model.FruitTransaction;
import service.OperationStrategy;
import service.ShopService;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction el : fruitTransactionList) {
            operationStrategy.getHandler(el.getOperation()).handle(el.getFruit(), el.getQuantity());
        }
    }
}
