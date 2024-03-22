package core.basesyntax.service;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.Operation;
import java.util.List;
import java.util.Map;

public interface StrategyService {
    void processData(List<FruitTransactionDto> fruitTransactionDtoList,
                     Map<Operation, OperationHandler> operationTypeList);
}
