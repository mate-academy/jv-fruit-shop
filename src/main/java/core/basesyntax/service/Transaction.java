package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Transaction {
    List<FruitTransaction> parseTransaction(List<String> transaction);
}
