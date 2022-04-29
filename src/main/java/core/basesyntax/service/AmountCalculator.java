package core.basesyntax.service;

import core.basesyntax.model.FruitRecordDto;
import java.util.List;
import java.util.Map;

public interface AmountCalculator {
    Map<String, Integer> calculateDataForReport(List<FruitRecordDto> fruitRecordDtos);
}
