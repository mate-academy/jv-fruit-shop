package core.basesyntax.services;

import core.basesyntax.dto.Transaction;

public interface Validator {
    boolean checkInputData(String[] data);

    Transaction.Operation findOperation(String operation);

    boolean checkOperation(int money);
}
