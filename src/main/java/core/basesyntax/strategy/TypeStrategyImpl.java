package core.basesyntax.strategy;

import core.basesyntax.strategy.type.TypeHandlers;
import java.util.Map;

public class TypeStrategyImpl implements TypeStrategy {
    private Map<Character, TypeHandlers> typeHandlersMap;

    public TypeStrategyImpl(Map<Character, TypeHandlers> typeHandlersMap) {
        this.typeHandlersMap = typeHandlersMap;
    }

    @Override
    public TypeHandlers get(Character type) {

        return typeHandlersMap.get(type);
    }
}
