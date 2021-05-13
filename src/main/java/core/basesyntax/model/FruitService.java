package core.basesyntax.model;

import core.basesyntax.dto.FruitRecordDto;
import java.util.List;

public interface FruitService {
    void save(List<FruitRecordDto> recordDtos);

    String getReport();
}
