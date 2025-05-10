package service.strategy;

import model.FruitRecord;
import service.strategy.strategyimpl.TypeService;

public interface TypeStrategy {
    TypeService getType(FruitRecord.Operation operation);
}
