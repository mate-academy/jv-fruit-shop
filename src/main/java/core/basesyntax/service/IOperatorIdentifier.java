package core.basesyntax.service;

import core.basesyntax.model.Operation;

public interface IOperatorIdentifier {
    Operation getOperator(String code);
}
