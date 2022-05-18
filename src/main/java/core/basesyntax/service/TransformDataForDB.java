package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface TransformDataForDB {
    List<Transaction> getTransactions(List<String> strings);
}
