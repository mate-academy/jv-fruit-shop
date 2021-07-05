package core.basesyntax.service.strategy;

import core.basesyntax.dto.FruitDto;

public interface OperationStrategy {
    void process(FruitDto transferAction);
}
