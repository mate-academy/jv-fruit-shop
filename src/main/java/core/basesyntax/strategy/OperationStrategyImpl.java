package core.basesyntax.strategy;

;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.PurchaseService;
import core.basesyntax.service.RemnantService;
import core.basesyntax.service.SupplyService;

public class OperationStrategyImpl implements OperationStrategy {

    @Override
    public OperationService get(FruitTransaction.Operation operation) {
        switch (operation) {
            case BALANCE:
                return new RemnantService();
            case SUPPLY:
            case RETURN:
                return new SupplyService();
            case PURCHASE:
                return new PurchaseService();
            default:
                throw new RuntimeException("No such operation: " + operation);
        }
    }
}
