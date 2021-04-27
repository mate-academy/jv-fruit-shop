package core.basesyntax.store;

import core.basesyntax.store.strategy.TypeHandler;

import java.util.Map;

public class StorageServiceImpl implements StorageService {
    TypeStrategy typeStrategy;

    public StorageServiceImpl(Map<String, TypeHandler> typeHandlerMap) {
        typeStrategy = new TypeStrategyImpl(typeHandlerMap);
    }

    @Override
    public void makeOperationDependsOnType(String[] line, int lineNumber) {
        typeStrategy.get(line[0]).makeOperation(line[1],
                Long.parseLong(line[2]), lineNumber);
    }
}
