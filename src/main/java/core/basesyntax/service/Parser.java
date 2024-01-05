package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Parser {
    List<FruitTransaction> parseData(List<String> rawData);
}
