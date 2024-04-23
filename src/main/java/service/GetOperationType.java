package service;

import model.OperationType;

public interface GetOperationType {
    OperationType checkAndGetOperationType(String line);
}
