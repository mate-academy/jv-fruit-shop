package service.impl;

import model.FruitTransaction;
import service.*;
import strategy.BalanceOperation;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl() {
        Map<FruitTransaction.Operation, OperationHandler> strategy = new HashMap<>();
        strategy.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        strategy.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        strategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        strategy.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        this.operationStrategy = new OperationStrategyImpl(strategy);
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.apply(transaction);
        }
    }
}
