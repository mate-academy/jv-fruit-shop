package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface CreateFruitTransactionList {
    List<FruitTransaction> create(List<String> strings);
}
