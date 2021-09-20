package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public interface DataParser {
    boolean parseAndAddToStorage(List<FruitRecord> records);
}
