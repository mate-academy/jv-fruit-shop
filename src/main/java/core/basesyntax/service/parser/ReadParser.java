package core.basesyntax.service.parser;

import core.basesyntax.model.fruit.Record;
import java.util.List;

public interface ReadParser {
    List<Record> parseFileData(List<String> data);
}
