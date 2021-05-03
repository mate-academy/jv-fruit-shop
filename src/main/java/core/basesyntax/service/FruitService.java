package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.impl.Operation;
import java.util.List;
import java.util.Map;

public interface FruitService {
    void saveData(List<FruitRecordDto> parsedLines,
                  Map<Operation, FruitOperationHandler> operationStrategy);

    String createReport();
}
