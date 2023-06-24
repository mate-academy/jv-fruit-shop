package core.basesyntax.service.impl;

import java.util.List;

public interface FruitTransactionGenerator {
    List<FruitTransaction> createFruitTransaction(List<String> metadata);
}
