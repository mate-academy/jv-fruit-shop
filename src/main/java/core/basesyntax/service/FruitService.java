package core.basesyntax.service;

import core.basesyntax.model.dto.FruitDataDto;

public interface FruitService {
    void applyCorrectOperationImpl(FruitDataDto fruitDataDto);

    String getReportFromDB();
}
