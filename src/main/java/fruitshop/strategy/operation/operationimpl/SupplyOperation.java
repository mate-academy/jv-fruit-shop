package fruitshop.strategy.operation.operationimpl;

import fruitshop.strategy.operation.OperationService;

public class SupplyOperation implements OperationService {
    @Override
    public int doSomeOperation(int currentAmount, int amount) {
        return currentAmount + amount;
    }
}
