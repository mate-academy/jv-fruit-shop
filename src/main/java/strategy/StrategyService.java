package strategy;

import model.Operation;

public interface StrategyService {
    OperationHandler get(Operation operation);
}
