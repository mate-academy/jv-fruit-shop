package core.basesyntax.servise.impl;

import core.basesyntax.servise.DataProcessorService;
import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class DataProcessorServiceImpl implements DataProcessorService {
    private final OperationStrategy strategy;

    public DataProcessorServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void processingData(List<FruitTransaction> listOfTransactions) {
        listOfTransactions.forEach(transaction -> strategy
                        .getOperationHandler(transaction)
                        .calculation(transaction));
    }
}
