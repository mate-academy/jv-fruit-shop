package core.basesyntax.service;

import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public interface ProcessingService {
    void removeHeading(List<String> list);

    void processData(List<String> list, OperationStrategy strategy);
}
