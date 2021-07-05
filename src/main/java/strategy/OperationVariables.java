package strategy;

import dto.Transaction;

public interface OperationVariables {
    int apply(Transaction transaction);
}
