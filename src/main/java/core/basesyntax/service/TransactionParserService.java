package core.basesyntax.service;

import core.basesyntax.transaction.FruitTransaction;
import java.util.List;

public interface TransactionParserService {
    List<FruitTransaction> getTransactions(List<String> linesFormFile);
}
