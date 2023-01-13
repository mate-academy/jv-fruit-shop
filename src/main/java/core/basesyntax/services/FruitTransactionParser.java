package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionParser {
    List<FruitTransaction> getFruitTransactionsList(List<String> data);
}
