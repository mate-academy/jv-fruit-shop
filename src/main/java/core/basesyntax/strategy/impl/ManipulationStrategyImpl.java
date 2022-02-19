package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.Manipulation;
import core.basesyntax.strategy.ManipulationService;
import core.basesyntax.strategy.ManipulationStrategy;
import java.util.Map;

public class ManipulationStrategyImpl implements ManipulationStrategy {
    private Map<Manipulation, ManipulationService> manipulationServiceMap;

    public ManipulationStrategyImpl(Map<Manipulation, ManipulationService> manipulationServiceMap) {
        this.manipulationServiceMap = manipulationServiceMap;
    }

    @Override
    public ManipulationService get(Manipulation manipulation) {
        return manipulationServiceMap.get(manipulation);
    }
}
