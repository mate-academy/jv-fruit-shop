package core.basesyntax.service.impl;

import core.basesyntax.record.Record;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class DataProcessingServiceImpl implements DataProcessingService {
    private static final OperationStrategy operationStrategy = new OperationStrategyImpl();

    @Override
    public void processData(List<Record> records) {
        for (Record record : records) {
            operationStrategy.get(record.operation()).operate(record.product());
        }
    }
}
