package core.basesyntax.service;

import core.basesyntax.model.fruit.Record;
import java.util.List;
import java.util.Map;

public interface Parser {
    List<Record> parseFileData(List<String> data);

    String parseProcessedData(Map<String, Integer> map);
}
