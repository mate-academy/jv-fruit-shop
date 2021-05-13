package core.basesyntax.datavalidation;

import core.basesyntax.operationswithfile.Transaction;
import java.util.List;

public interface OperationTypeValidator {
    void validation(List<Transaction> transactionList);
}
