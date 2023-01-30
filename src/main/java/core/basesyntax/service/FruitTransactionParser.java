package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionParser {
    List<FruitTransaction> parse(String transactions);
}
