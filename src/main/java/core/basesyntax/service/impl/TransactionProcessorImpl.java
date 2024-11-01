package core.basesyntax.service.impl;

import core.basesyntax.model.ShopTransaction;
import core.basesyntax.service.StrategyOperationService;
import core.basesyntax.service.TransactionProcessor;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private StrategyOperationService strategyOperationService;

    public TransactionProcessorImpl(StrategyOperationService strategyOperationService) {
        this.strategyOperationService = strategyOperationService;
    }

    @Override
    public void process(List<ShopTransaction> transactions) {
        for (ShopTransaction transaction : transactions) {
            strategyOperationService.get(transaction.getType()).handle(transaction);
        }
    }
}
