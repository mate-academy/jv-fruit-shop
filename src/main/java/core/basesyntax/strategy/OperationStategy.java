package core.basesyntax.strategy;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;

public interface OperationStategy {
    List<OperationHandler> get(FruitTransactionDto dto);
}
