package core.basesyntax.strategy.actions;

import core.basesyntax.storage.Storage;

public class PurchaseActionHandler implements ActionHandler {
    @Override
    public void apply(Storage storage, String fruit, Integer quantity) {
        storage.minus(fruit, quantity);
    }

    @Override
    public String getCorrespondingAction() {
        return "p";
    }
}
