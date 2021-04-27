package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.TypeHandler;
import java.util.Map;

public class TypeStrategyImpl implements TypeStrategy {
    private Map<Fruit.Type, TypeHandler> typeHandlerMap;

    public TypeStrategyImpl(Map<Fruit.Type, TypeHandler> typeHandlerMap) {
        this.typeHandlerMap = typeHandlerMap;
    }

    @Override
    public TypeHandler getStrategy(Fruit.Type type) {
        return typeHandlerMap.get(type);
    }
}
