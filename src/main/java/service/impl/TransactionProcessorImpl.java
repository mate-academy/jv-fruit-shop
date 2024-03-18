package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.StrategyService;
import service.TransactionProcessor;

public class TransactionProcessorImpl implements TransactionProcessor {
    private StrategyService strategyService;

    public TransactionProcessorImpl(StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            strategyService.get(transaction.getOperation()).operationProcess(transaction);
        }
    }
}
