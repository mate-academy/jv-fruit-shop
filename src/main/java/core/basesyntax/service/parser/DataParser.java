package core.basesyntax.service.parser;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public interface DataParser {
    List<FruitRecord> parseData(String fileName);
}
