package core.basesyntax;

import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parseTransactions(List<String> transactionLines);

}
