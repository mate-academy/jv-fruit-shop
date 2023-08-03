package core.strategy;

import core.service.OperationType;
import core.transactions.OperationHandler;
import java.util.Map;

public interface DataOperationStrategy {
    Map<OperationType, OperationHandler> strategy();
}
