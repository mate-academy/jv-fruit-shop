package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Parser {
    public List<FruitTransaction> parseData(List<String> data);
}
