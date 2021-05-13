package core.basesyntax.datavalidation;

import core.basesyntax.operationswithfile.Transaction;
import java.util.List;

public class OperationTypeValidatorImpl implements OperationTypeValidator {
    @Override
    public void validation(List<Transaction> transactionList) {
        for (int i = 0; i < transactionList.size(); i++) {
            if (!"b".equals(transactionList.get(i).getOperationType())
                    && !"p".equals(transactionList.get(i).getOperationType())
                    && !"r".equals(transactionList.get(i).getOperationType())
                    && !"s".equals(transactionList.get(i).getOperationType())) {
                throw new RuntimeException("NotValid operation type! "
                        + transactionList.get(i).toString());
            }
        }
    }
}
