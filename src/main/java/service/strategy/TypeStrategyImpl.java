package service.strategy;

import java.util.HashMap;
import model.FruitRecord;
import service.strategy.strategyimpl.TypeService;

public class TypeStrategyImpl implements TypeStrategy {
    private HashMap<FruitRecord.Operation, TypeService> typeServiceHashMap;

    public TypeStrategyImpl(HashMap<FruitRecord.Operation, TypeService> typeServiceHashMap) {
        this.typeServiceHashMap = typeServiceHashMap;
    }

    @Override
    public TypeService getType(FruitRecord.Operation operation) {
        return typeServiceHashMap.get(operation);
    }
}
