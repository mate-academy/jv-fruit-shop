package strategy.impl;

import java.util.Map;
import model.Transaction;
import service.transaction.HandlerTransaction;
import strategy.StrategyTransaction;

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
