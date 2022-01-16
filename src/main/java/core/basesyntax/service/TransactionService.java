package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.function.Consumer;

public interface TransactionService {
    void accept(Transaction transaction);
}
