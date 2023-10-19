package core.basesyntax.strategy;

;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.PurchaseOperationHandler;
import core.basesyntax.service.RemnantOperationHandler;
import core.basesyntax.service.SupplyOperationHandler;

public class OperationStrategyImpl implements OperationStrategy {

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        switch (operation) {
            case BALANCE:
                return new RemnantOperationHandler();
            case SUPPLY:
            case RETURN:
                return new SupplyOperationHandler();
            case PURCHASE:
                return new PurchaseOperationHandler();
            default:
                throw new RuntimeException("No such operation: " + operation);
        }
    }
}
