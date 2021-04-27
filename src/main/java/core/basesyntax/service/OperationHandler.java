package core.basesyntax.service;

import core.basesyntax.model.FruitDto;
import core.basesyntax.model.FruitStrategy;
import java.util.List;

public class OperationHandler {
    public static void handleOperation(List<FruitDto> fruitDtos) {
        FruitStrategy.initialize();
        for (FruitDto fruitDto : fruitDtos) {
            FruitStrategy.fruitStorageStrategy
                    .get(fruitDto.getOperation())
                    .doOperation(fruitDto);
        }
    }
}
