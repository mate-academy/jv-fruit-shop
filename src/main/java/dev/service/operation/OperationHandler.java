package dev.service.operation;

import dev.repository.Repository;

public interface OperationHandler {
    void update(Repository repository, String keyFruit, Integer value);
}
