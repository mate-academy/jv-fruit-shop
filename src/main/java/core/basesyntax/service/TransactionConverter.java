package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionConverter {
    List<FruitTransaction> parse(String data);
}
