package core.basesyntax.data;

import core.basesyntax.handlers.Operations;
import core.basesyntax.services.FruitsService;
import core.basesyntax.storage.FruitDataBase;
import java.util.List;
import java.util.Map;

public interface DataParser {
    void convert(List<String> listWithRawData,
                 Map<Operations, FruitsService> strategies,
                 FruitDataBase fruitDataBase);
}
