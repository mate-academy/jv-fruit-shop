package core.basesyntax.service.result;

import core.basesyntax.models.Fruit;
import core.basesyntax.service.counter.OperationType;
import java.util.List;
import java.util.Map;

public interface ResultFromReport {
    void getResultFromReport(List<String> dataFromReport, Map<String,
            OperationType> operationStrategyMap, Map<Fruit, Integer> dataToUpdateReport,
                             Map<String, Fruit> fruitTypes);
}
