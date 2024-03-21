package strategy;

import dto.FruitTransactionDto;
import service.operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransactionDto dto);
}
