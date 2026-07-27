package core.basesyntax.parse;

import core.basesyntax.model.FruitTransaction;

public interface OperationParser {
    FruitTransaction.Operation getOperation(String code);
}
