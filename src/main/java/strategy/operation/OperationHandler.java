package strategy.operation;

import service.StorageService;

public interface OperationHandler {
    void execute(String fruit, int quantity, StorageService storageService);
}
