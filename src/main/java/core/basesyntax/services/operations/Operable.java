package core.basesyntax.services.operations;

import core.basesyntax.services.FruitDto;
import java.util.Map;

public interface Operable {
    boolean updateStorage(Map<String, Map<String, Integer>> store, FruitDto dto);
}
