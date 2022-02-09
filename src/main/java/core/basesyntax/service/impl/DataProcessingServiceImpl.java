package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.stream.IntStream;

public class DataProcessingServiceImpl implements DataProcessingService {
    private final OperationStrategy operationStrategy;

    public DataProcessingServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processingDate(List<FruitTransaction> date) {
        IntStream.range(0, date.size()).forEach(i -> {
            OperationService operationService = operationStrategy
                    .applyOperation(date.get(i).getOperation());
            operationService.processOperation(date.get(i));
        });
    }
}
