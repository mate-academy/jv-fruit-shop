package core.basesyntax.service.parse;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public interface DataParser {
    List<FruitRecord> parseFruitRecords(List<String> data);
}
