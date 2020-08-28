package core.basesyntax.service.iooperations;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.FruitStorageStrategy;

import java.util.List;

public class OperationHandler {
    public static void handleOperation(List<FruitDto> fruitDtos) {
        FruitStorageStrategy.initialize();
        for (FruitDto fruitDto : fruitDtos) {
            FruitStorageStrategy.fruitStorageStrategy.get(fruitDto.getOperation()).doOperation(fruitDto);
        }
    }
}
