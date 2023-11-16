package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitMapper {
    List<FruitTransaction> mapLinesIntoTransactions(List<String> lines);
}
