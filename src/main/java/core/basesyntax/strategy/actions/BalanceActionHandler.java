package core.basesyntax.strategy.actions;

import core.basesyntax.storage.Storage;

public class BalanceActionHandler implements ActionHandler {
    @Override
    public void apply(Storage storage, String fruit, Integer quantity) {
        storage.put(fruit, quantity);
    }

    @Override
    public String getCorrespondingAction() {
        return "b";
    }
}
