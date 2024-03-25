package core.basesyntax.service;

import core.basesyntax.model.Operation;

public interface IOperationIdentifier {
    Operation get(String code);
}
