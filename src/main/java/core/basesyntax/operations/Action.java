package core.basesyntax.operations;

import core.basesyntax.service.TransactionParser;

public interface Action {
    boolean action(TransactionParser transaction);
}
