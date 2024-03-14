package core.basesyntax.service;

import core.basesyntax.model.Operation;

public class TransactionValueCalculator {
    public static int calculateTransactionValue(String operationCode) {
        if (Operation.PURCHASE.getCode().equals(operationCode)) {
            return -1;
        } else if (Operation.BALANCE.getCode().equals(operationCode)
                || Operation.SUPPLY.getCode().equals(operationCode)
                || Operation.RETURN.getCode().equals(operationCode)) {
            return 1;
        } else {
            throw new RuntimeException("Unknown operation code: " + operationCode);
        }
    }
}
