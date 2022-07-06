package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionConvertor {
    List<FruitTransaction> getFruitTransactions(List<String> lines);
}
