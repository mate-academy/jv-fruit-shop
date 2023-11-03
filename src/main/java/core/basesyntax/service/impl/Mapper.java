package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Mapper {
    List<FruitTransaction> mapLinesIntoTransaction(List<String> lines);
}
