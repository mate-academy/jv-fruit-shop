package core.basesyntax.store;

import core.basesyntax.model.OperationType;
import core.basesyntax.store.strategy.TypeHandler;

import java.util.Map;

public class TypeStrategyImpl implements TypeStrategy {
    private final Map<OperationType, TypeHandler> typeHandlerMap;

    public TypeStrategyImpl(Map<OperationType, TypeHandler> typeHandlerMap) {
        this.typeHandlerMap = typeHandlerMap;
    }

    @Override
    public TypeHandler get(OperationType operationType) {
        return typeHandlerMap.get(operationType);
    }
}
