package core.basesyntax.service;

import core.basesyntax.model.Transaction;

public interface OperationMapper {
    Transaction.Operation mapToEnumValue(String operation);
}
