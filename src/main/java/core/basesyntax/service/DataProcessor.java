package core.basesyntax.service;

import java.util.List;

public interface DataProcessor {
    void processData(List<String> activities, OperationStrategy operationStrategy);

    String provideReport();
}
