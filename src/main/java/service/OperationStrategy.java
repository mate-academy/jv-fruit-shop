package service;

import model.fruitActivitiesModel;
import strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(fruitActivitiesModel.Operation type);
}