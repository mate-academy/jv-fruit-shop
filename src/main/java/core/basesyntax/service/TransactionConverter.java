package core.basesyntax.service;

import java.util.List;

public interface TransactionConverter {
    List<FruitTransaction> convertLines(List<String> lines);
}
