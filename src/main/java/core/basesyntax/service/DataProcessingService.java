package core.basesyntax.service;

import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public interface DataProcessingService {
    void processData(List<String> data, OperationStrategy strategy);
}
