package core.basesyntax.store;

import core.basesyntax.store.strategy.TypeHandler;

import java.util.Map;

public class TypeStrategyImpl implements TypeStrategy {
    private final Map<String, TypeHandler> typeHandlerMap;

    public TypeStrategyImpl(Map<String, TypeHandler> typeHandlerMap) {
        this.typeHandlerMap = typeHandlerMap;
    }

    @Override
    public TypeHandler get(String type) {
        return typeHandlerMap.get(type);
    }
}
