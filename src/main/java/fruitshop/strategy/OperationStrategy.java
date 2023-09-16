package fruitshop.strategy;

import fruitshop.model.Operation;
import fruitshop.strategy.operation.OperationService;
import fruitshop.strategy.operation.operationimpl.BalanceOperation;
import fruitshop.strategy.operation.operationimpl.PurchaseOperation;
import fruitshop.strategy.operation.operationimpl.ReturnOperation;
import fruitshop.strategy.operation.operationimpl.SupplyOperation;

public class OperationStrategy {
    public OperationService getCertainOperation(Operation operation) {
        switch (operation) {
            case BALANCE: return new BalanceOperation();
            case RETURN: return new ReturnOperation();
            case SUPPLY: return new SupplyOperation();
            case PURCHASE: return new PurchaseOperation();
            default: throw new RuntimeException("Invalid operation: " + operation.name());
        }
    }
}
