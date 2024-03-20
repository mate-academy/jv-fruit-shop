package core.basesyntax.services.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.services.FruitTransactionProcessor;
import core.basesyntax.services.operations.FruitOperationStrategy;
import java.util.List;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private FruitOperationStrategy strategy;

    public FruitTransactionProcessorImpl(FruitOperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransactionDto> dtos) {
        for (var fruitTransaction : dtos) {
            strategy.getHandler(fruitTransaction)
                    .forEach(handler -> handler.apply(fruitTransaction));
        }
    }
}
