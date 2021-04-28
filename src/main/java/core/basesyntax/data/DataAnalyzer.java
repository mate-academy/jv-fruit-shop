package core.basesyntax.data;

import core.basesyntax.dto.Dto;
import core.basesyntax.handlers.Operations;
import core.basesyntax.services.FruitsService;
import core.basesyntax.storage.FruitDataBase;
import java.util.List;
import java.util.Map;

public interface DataAnalyzer {
    void analyze(List<Dto> listWithDtos, Map<Operations, FruitsService> fruitStrategies,
                 FruitDataBase fruitDataBase);
}

