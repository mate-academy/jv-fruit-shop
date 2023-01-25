package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    public List<FruitTransaction> parse(List<String> transactions);
}
