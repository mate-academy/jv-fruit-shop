package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopProcessService;
import core.basesyntax.service.strategy.OperationStrategy;

import java.util.List;

public class FruitShopProcessServiceImp implements FruitShopProcessService {
    private final OperationStrategy operationStrategy;

    public FruitShopProcessServiceImp(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void fruitShopProcess(List<FruitTransaction> transactionList) {
        for (FruitTransaction transaction : transactionList) {
            operationStrategy.getOperation(transaction.getOperation()).operationTransaction(transaction);
        }
    }
}
