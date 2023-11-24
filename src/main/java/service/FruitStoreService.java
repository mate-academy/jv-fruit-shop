package service;

import db.FruitStorage;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import strategy.BalanceStrategy;
import strategy.PurchaseStrategy;
import strategy.ReturnStrategy;
import strategy.SupplyStrategy;
import strategy.TransactionStrategy;

public class FruitStoreService {
    private Map<FruitTransaction.Operation, TransactionStrategy> strategyMap;

    public FruitStoreService() {
        strategyMap = Map.of(FruitTransaction.Operation.BALANCE, new BalanceStrategy(),
                FruitTransaction.Operation.SUPPLY, new SupplyStrategy(),
                FruitTransaction.Operation.PURCHASE, new PurchaseStrategy(),
                FruitTransaction.Operation.RETURN, new ReturnStrategy());
    }

    public FruitStorage processTransactions(List<FruitTransaction> transactions) {
        FruitStorage fruitStorage = new FruitStorage();

        for (FruitTransaction transaction : transactions) {
            TransactionStrategy strategy = strategyMap.get(transaction.getOperation());
            if (strategy != null) {
                strategy.apply(fruitStorage, transaction);
            } else {
                throw new StrategyException(
                        "Strategy not found for operation: " + transaction.getOperation());
            }
        }

        return fruitStorage;
    }
}
