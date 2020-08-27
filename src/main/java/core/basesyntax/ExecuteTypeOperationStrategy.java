package core.basesyntax;

import core.basesyntax.model.FruitDto;
import java.util.Map;
import java.util.NoSuchElementException;

public class ExecuteTypeOperationStrategy {
    private Map<String, StoreOperationsExecutable> executors;

    public ExecuteTypeOperationStrategy(Map<String, StoreOperationsExecutable> executorsMap) {
        this.executors = executorsMap;
    }

    public void executeTheRequiredOperation(Storage storage, FruitDto fruitDto) {
        StoreOperationsExecutable executor = executors.get(fruitDto.getTypeOperation());
        if (executor == null) {
            throw new NoSuchElementException("Can't find correct executor for type "
                    + fruitDto.getTypeOperation());
        }
        executor.executeOperation(storage, fruitDto);
    }
}
