package service;

import java.util.Map;
import model.Operation;
import strategy.OperationService;

public interface UserService {
    void formReport(Map<Operation, OperationService> operationMap, String fromFile, String toFile);
}

