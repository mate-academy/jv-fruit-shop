package core.basesyntax.service;

import java.util.List;

public interface Parser {
    List<FruitTransaction> parse(List<String> lines);
}
