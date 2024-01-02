package core.basesyntax.service;

import java.util.List;

public interface TransactionConverter {
    List<FruitTransaction> convert(List<String> list);
}
