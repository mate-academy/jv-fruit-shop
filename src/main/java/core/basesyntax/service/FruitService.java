package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;
import java.util.List;
import java.util.Map;

public interface FruitService {
    Map<String, Integer> getFruitReport();

    void applyOperation(List<FruitRecordDto> fruitRecordDtoList);
}
