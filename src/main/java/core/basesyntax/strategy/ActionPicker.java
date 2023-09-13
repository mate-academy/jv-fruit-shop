package core.basesyntax.strategy;

import core.basesyntax.model.Operation;

public class ActionPicker {
    public int pickAction(Operation operation) {
        return switch (operation.getName()) {
            case BALANCE -> new BalanceAction().action(operation);
            case RETURN -> new ReturnAction().action(operation);
            case SUPPLY -> new SupplyAction().action(operation);
            case PURCHASE -> new PurchaseAction().action(operation);
            default -> throw new RuntimeException("No such operation found!");
        };
    }
}
