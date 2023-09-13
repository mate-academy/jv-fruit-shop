package core.basesyntax.strategy;

import core.basesyntax.model.Operation;

public class ActionPicker {
    public int pickAction(Operation operation) {
        switch (operation.getName()) {
            case BALANCE:
                return new BalanceAction().action(operation);
            case RETURN:
                return new ReturnAction().action(operation);
            case SUPPLY:
                return new SupplyAction().action(operation);
            case PURCHASE:
                return new PurchaseAction().action(operation);
            default:
                throw new RuntimeException("No such action found!");
        }
    }
}
