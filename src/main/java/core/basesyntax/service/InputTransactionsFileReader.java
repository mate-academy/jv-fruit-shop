package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface InputTransactionsFileReader {
    List<FruitTransaction> read(String fileName);
}
