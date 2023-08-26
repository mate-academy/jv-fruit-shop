package service;

import service.storage.PerformingOperation;

public interface OperationStrategy {
    PerformingOperation get(String code);
}
