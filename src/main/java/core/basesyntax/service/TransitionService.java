package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface TransitionService {
    List<Transaction> getTransactionsList(List<String> fileLines);
}
