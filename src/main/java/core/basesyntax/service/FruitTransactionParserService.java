package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionParserService {
    List<FruitTransaction> parseData(String data);
}
