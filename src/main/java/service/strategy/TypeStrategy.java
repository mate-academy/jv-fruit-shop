package service.strategy;

import model.FruitRecord;
import service.strategy.strategyimpl.OperationHandler;

public interface TypeStrategy {
    OperationHandler getType(FruitRecord.Operation operation);
}
