package core.basesyntax.strategy;

import core.basesyntax.model.dto.FruitDto;

public interface Operation {
    void process(FruitDto fruit);
}
