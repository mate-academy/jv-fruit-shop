package core.basesyntax.service;

import java.util.Map;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationService;

public interface UserService {
    void formReport(Map<Operation, OperationService> operationMap, String fromFile, String toFile);
}

