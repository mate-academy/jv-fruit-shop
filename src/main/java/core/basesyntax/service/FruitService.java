package core.basesyntax.service;

import core.basesyntax.model.dto.FruitDataDto;
import java.util.List;

public interface FruitService {
    void applyCorrectOperationImpl(List<FruitDataDto> fruitDataDtoList);

    String getReportFromDB();
}
