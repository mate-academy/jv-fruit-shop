package service.operation;

import java.util.Map;
import model.Operation;

public interface OperationHandler {
    int getAmount(Operation operation, Map<String, Integer> fruitsStorage);
}
