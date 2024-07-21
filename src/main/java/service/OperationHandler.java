package service;

import model.FruitTransaction;
import service.impl.Storage;

public interface OperationHandler {
    void handle(FruitTransaction transaction, Storage storage);
}
