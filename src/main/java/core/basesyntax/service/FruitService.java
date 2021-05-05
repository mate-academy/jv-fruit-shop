package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;
import java.util.List;

public interface FruitService {
    String getFruitReport();

    void applyOperation(List<FruitRecordDto> fruitRecordDtoList);
}
