package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessingService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class TransactionProcessingServiceImpl implements TransactionProcessingService {
    private final OperationStrategy strategy = new OperationStrategyImpl();

    @Override
    public void accept(List<FruitTransaction> transactions) {
        transactions.forEach(t -> strategy.getHandlerByTransaction(t).evaluateTransaction(t));
    }
}
