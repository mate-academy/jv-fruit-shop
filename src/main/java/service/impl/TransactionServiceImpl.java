package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.StrategyService;
import service.TransactionService;

public class TransactionServiceImpl implements TransactionService {
    private StrategyService strategyService;

    public TransactionServiceImpl(StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    @Override
    public void transactionsProcess(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            strategyService.get(transaction.getOperation()).operationProcess(transaction);
        }
    }
}
