package service;

import model.FruitTransaction;
import service.activities.TransactionHandler;

public interface ActivitiesStrategy {
    TransactionHandler get(FruitTransaction.Operation operation);
}
