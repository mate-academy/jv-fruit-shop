package service.read;

import model.FruitTransaction;

public interface OperationTypeService {
    FruitTransaction.Operation getOperation(String operation);
}
