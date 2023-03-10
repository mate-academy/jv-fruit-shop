package com.mate.fruitshop.service.impl;

import com.mate.fruitshop.model.Transaction;
import com.mate.fruitshop.service.TransactionsProcessingService;
import com.mate.fruitshop.strategy.ProcessBalanceTransaction;
import com.mate.fruitshop.strategy.ProcessPurchaseTransaction;
import com.mate.fruitshop.strategy.ProcessReturnTransaction;
import com.mate.fruitshop.strategy.ProcessSupplyTransaction;
import com.mate.fruitshop.strategy.TransactionProcessingStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionsProcessingServiceImpl implements TransactionsProcessingService {
    private final Map<Transaction.Operation, TransactionProcessingStrategy> strategyMap;

    public TransactionsProcessingServiceImpl() {
        this.strategyMap = new HashMap<>();
        this.strategyMap.put(Transaction.Operation.BALANCE, new ProcessBalanceTransaction());
        this.strategyMap.put(Transaction.Operation.PURCHASE, new ProcessPurchaseTransaction());
        this.strategyMap.put(Transaction.Operation.SUPPLY, new ProcessSupplyTransaction());
        this.strategyMap.put(Transaction.Operation.RETURN, new ProcessReturnTransaction());
    }

    @Override
    public boolean process(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            TransactionProcessingStrategy strategy = strategyMap.get(transaction.getOperation());
            strategy.process(transaction);
        }
        return true;
    }
}
