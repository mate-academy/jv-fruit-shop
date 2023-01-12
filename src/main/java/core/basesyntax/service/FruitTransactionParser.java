package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionParser {
    public List<FruitTransaction> transformToTransaction(List<String> operations);
}
