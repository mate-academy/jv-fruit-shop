package core.basesyntax.service.parser;

import core.basesyntax.model.FruitRecordDto;
import java.util.List;

public interface DataParser {
    List<FruitRecordDto> parseData(List<String> rawFruitRecords);
}
