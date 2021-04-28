package core.basesyntax.parser;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;

import java.util.List;
import java.util.Set;

public interface Parser {
    List<FruitRecord> parseLines(List<String> lines);
}
