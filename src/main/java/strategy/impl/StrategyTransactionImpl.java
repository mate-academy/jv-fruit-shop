package strategy.impl;

import model.Transaction;
import service.transaction.HandlerTransaction;
import strategy.StrategyTransaction;

import java.util.Map;

public class StrategyTransactionImpl implements StrategyTransaction {
    private Map<Transaction, HandlerTransaction> transactionHandlerTransactionMap;

    public StrategyTransactionImpl(
            Map<Transaction, HandlerTransaction>
                    transactionHandlerTransactionMap) {
        this.transactionHandlerTransactionMap = transactionHandlerTransactionMap;
    }

    @Override
    public HandlerTransaction get(Transaction transaction) {
        return transactionHandlerTransactionMap.get(transaction);
    }
}
