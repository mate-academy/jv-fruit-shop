package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataParser {
    List<FruitTransaction> parseDate(List<String> dataFromFile);
}
