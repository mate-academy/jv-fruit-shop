package core.basesyntax.parser;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public interface Parser {
    List<FruitRecord> parseLines(List<String> lines);
}
