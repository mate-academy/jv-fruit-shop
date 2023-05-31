package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParserInFruitTransaction {
    List<FruitTransaction> parseData(List<String> data);
}
