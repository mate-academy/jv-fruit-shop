package core.basesyntax.service.operationwithdata;

import core.basesyntax.dto.FruitDto;
import java.util.List;

public interface OperationHandler {
    void operationProcessing(List<FruitDto> fruitDtos);
}
