package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Activity;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandlerImpl implements OperationHandler {
    @Override
    public void process(Activity activity) {
        Storage.storeItems.merge(activity.getItem(), activity.getQuantity(), Integer::sum);
    }
}
