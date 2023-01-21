package core.basesyntax.service;

import core.basesyntax.model.FruitReport;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionParserService {

    List<FruitReport> dataforReport(List<FruitTransaction> readFromFile);
}
