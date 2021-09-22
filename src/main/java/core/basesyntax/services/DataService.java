package core.basesyntax.services;

import core.basesyntax.model.FruitRecordDto;
import java.util.List;
import java.util.Map;

public interface DataService {
    List<String> generateReport(OperationStrategy operationStrategy,
                                List<FruitRecordDto> list, Map<String, Integer> storage);
}
