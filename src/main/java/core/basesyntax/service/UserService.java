package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationService;
import java.util.Map;

public interface UserService {
    void formReport(Map<Operation, OperationService> operationMap, String fromFile, String toFile);
}

