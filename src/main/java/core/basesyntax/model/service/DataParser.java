package core.basesyntax.model.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataParser {
    List<FruitTransaction> parse(List<String> lines);
}
