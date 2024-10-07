package service.strategy.strategyimpl;

import model.FruitRecord;

import java.util.Map;

public interface OperationHandler {
    void apply(FruitRecord transaction);
}
