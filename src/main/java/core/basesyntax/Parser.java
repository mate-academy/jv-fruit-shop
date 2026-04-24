package core.basesyntax;

import java.util.List;

public interface Parser {
    List<FruitTransaction> parse(List<String> lines);
}
