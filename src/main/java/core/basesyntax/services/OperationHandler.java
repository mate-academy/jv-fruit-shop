package core.basesyntax.services;

import core.basesyntax.dto.Transaction;
import java.util.NoSuchElementException;

public interface OperationHandler {
    static Transaction.Operation findOperation(String operation) {
        switch (operation) {
            case "b": return Transaction.Operation.BALANCE;
            case "s": return Transaction.Operation.SUPPLY;
            case "p": return Transaction.Operation.PURCHASE;
            case "r": return Transaction.Operation.RETURN;
            default: throw new NoSuchElementException("Incorrect operation");
        }
    }
}
