package service;

import model.FruitTransaction;
import service.activities.ActivitiesHandler;

public interface ActivitiesStrategy {
    ActivitiesHandler get(FruitTransaction.Operation operation);
}
