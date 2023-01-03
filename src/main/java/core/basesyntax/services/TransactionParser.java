package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parse(List<String> fruitData);
}
