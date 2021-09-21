package core.basesyntax.db;

import core.basesyntax.service.strategy.operation.OperationHandler;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static Map<String, Integer> fruitStorage = new HashMap<>();
    public static Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
}
