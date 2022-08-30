package core.basesyntax.servise;

import core.basesyntax.model.Transaction;

import java.util.List;

public interface DataOperationHandler {
    List<Transaction> handle();

}
