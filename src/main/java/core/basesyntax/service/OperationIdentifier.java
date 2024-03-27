package core.basesyntax.service;

import core.basesyntax.model.Operation;

public interface OperationIdentifier {
    Operation get(String code);
}
