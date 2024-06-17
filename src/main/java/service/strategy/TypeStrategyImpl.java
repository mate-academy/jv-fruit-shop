package service.strategy;

import java.util.HashMap;
import model.FruitRecord;
import service.strategy.strategyimpl.TypeService;

public class TypeStrategyImpl implements TypeStrategy {
    private HashMap<FruitRecord.Type, TypeService> typeServiceHashMap;

    public TypeStrategyImpl(HashMap<FruitRecord.Type, TypeService> typeServiceHashMap) {
        this.typeServiceHashMap = typeServiceHashMap;
    }

    @Override
    public TypeService getType(FruitRecord.Type type) {
        return typeServiceHashMap.get(type);
    }
}
