package core.basesyntax.service;

import core.basesyntax.service.impl.FruitTransaction;
import java.util.List;

public interface DataTransactionParser {
    List<FruitTransaction> parseDataTransaction(String data);
}
