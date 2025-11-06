package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public abstract class DataParser {
    public abstract List<FruitTransaction> parse(List<String> data);
}
