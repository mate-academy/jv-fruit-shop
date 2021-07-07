package core.basesyntax.service;

import core.basesyntax.dto.FruitRecordDto;
import java.util.List;

public interface FruitService {
    void saveData(List<FruitRecordDto> fruitRecords);

    String getFruitReport();
}
