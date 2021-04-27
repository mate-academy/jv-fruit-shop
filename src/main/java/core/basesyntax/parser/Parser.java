package core.basesyntax.parser;

import core.basesyntax.model.Fruit;

import java.util.List;
import java.util.Set;

public interface Parser {
    List<Fruit> parseLines(List<String[]> lines, Set<String> types);
}
