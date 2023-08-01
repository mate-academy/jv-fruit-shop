package core.basesyntax.service.interfaces;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface TransactionParserService {
    List<FruitTransaction> parseFruitTransaction(String data);

    String parseReport(Map<Fruit, Integer> mapOfRecords);
}
