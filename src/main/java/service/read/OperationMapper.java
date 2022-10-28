package service.read;

import model.FruitTransaction;

public interface OperationMapper {
    FruitTransaction.Operation mapToOperation(String operation);
}
