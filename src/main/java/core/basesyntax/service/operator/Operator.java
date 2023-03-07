package core.basesyntax.service.operator;

import core.basesyntax.model.Transaction;

public interface Operator {

    int openShift();

    int closeShift();

    void newTransaction(Transaction transaction);
}
