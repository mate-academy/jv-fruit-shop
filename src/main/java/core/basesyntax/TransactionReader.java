package core.basesyntax;

import java.util.List;

public interface TransactionReader {
    List<FruitTransaction> readTransactions(String filePath);
}
