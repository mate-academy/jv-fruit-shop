package service.operations;

import dto.FruitTransactionDto;

public interface OperationHandler {
    void apply(FruitTransactionDto dto);
}
