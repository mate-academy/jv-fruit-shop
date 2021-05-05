package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;
import java.util.List;

public interface FruitService {
    void saveData(List<FruitRecordDto> recordDtos);

    String getReport();
}
