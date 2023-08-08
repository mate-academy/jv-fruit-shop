package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionParserService {
    List<FruitTransaction> parseDataFromList(List<String> data);
}
