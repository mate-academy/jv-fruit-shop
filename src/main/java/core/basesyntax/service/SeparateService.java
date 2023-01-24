package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface SeparateService {
    List<Transaction> parseTransactionList(List<String> transactions);
}
