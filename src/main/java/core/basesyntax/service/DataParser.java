package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import java.util.List;
import java.util.Map;

public interface DataParser {
    Map<Fruit, Integer> parseDto(List<FruitRecordDto> records);
}
