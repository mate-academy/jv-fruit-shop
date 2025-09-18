package core.basesyntax.interfaces;

import core.basesyntax.FruitRecord;
import java.util.Map;

public interface FruitOperation {
    void process(FruitRecord records, Map<String, Integer> stock);
}
