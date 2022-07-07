package core.service;

import core.db.FruitTransaction;

public interface OperationHandler {
    void addTransaction(FruitTransaction transaction);
}
