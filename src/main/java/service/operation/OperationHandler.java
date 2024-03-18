package service.operation;

import model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction fruit);
}
