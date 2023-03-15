package core.basesyntax.strategy.actions;

import core.basesyntax.storage.Storage;

public class ReturnActionHandler implements ActionHandler {
    @Override
    public void apply(Storage storage, String fruit, Integer quantity) {
        storage.plus(fruit, quantity);
    }

    @Override
    public String getCorrespondingAction() {
        return "r";
    }
}
