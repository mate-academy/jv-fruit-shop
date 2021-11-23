package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.GetManipulationType;
import core.basesyntax.strategy.Manipulation;
import core.basesyntax.strategy.ManipulationService;
import java.util.Map;

public class GetManipulationTypeImpl implements GetManipulationType {
    private Map<Manipulation, ManipulationService> manipulationServiceMap;

    public GetManipulationTypeImpl(Map<Manipulation, ManipulationService> manipulationServiceMap) {
        this.manipulationServiceMap = manipulationServiceMap;
    }

    @Override
    public ManipulationService get(Manipulation manipulation) {
        return manipulationServiceMap.get(manipulation);
    }
}
