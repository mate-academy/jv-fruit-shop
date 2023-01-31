package core.basesyntax.service;

import core.basesyntax.models.FruitTransaction;
import java.util.List;

public interface FruitTransactionParser {
    List<FruitTransaction> getFruitTransactionsList(List<String> data);
}
