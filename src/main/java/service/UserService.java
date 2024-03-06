package service;

import model.Operation;
import strategy.OperationService;
import java.util.Map;

public interface UserService {
    void formReport(Map<Operation, OperationService> operationServiceMap, String fromFile, String toFile);
}

