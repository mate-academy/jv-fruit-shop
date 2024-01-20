package core.basesyntax.transaction;

import java.util.List;

public interface TransactionConverter {
    List<FruitTransaction> convert(List<String> lines);
}
