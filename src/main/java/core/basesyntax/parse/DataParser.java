package core.basesyntax.parse;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface DataParser {
    List<FruitTransaction> parse(List<String> lines);
}
