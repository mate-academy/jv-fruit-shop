package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ToFruitTransaction {
    List<FruitTransaction> linesToFruitTransaction(List<String> lines);
}
