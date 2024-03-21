package core.basesyntax.service;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.List;
import java.util.Map;

public interface StrategyService {
    void processData(List<FruitTransactionDto> fruitTransactionDtoList,
                     Map<String, OperationHandler> operationTypeList);
}
