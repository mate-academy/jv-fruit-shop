package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.OperationStrategy;
import service.ShopService;

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
