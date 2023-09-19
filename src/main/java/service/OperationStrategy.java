package service;

import model.FruitActivitiesModel;
import strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitActivitiesModel.Operation type);
}
