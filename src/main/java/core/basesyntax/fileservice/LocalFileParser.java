package core.basesyntax.fileservice;

import core.basesyntax.model.FruitBatch;
import java.util.List;

public interface LocalFileParser {
    List<FruitBatch> parseList(List<List<String>> list);
}
