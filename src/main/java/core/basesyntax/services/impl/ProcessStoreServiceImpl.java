package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.ActionStrategy;
import core.basesyntax.services.ProcessStoreService;
import core.basesyntax.services.actions.ActionHandler;
import java.util.List;

public class ProcessStoreServiceImpl implements ProcessStoreService {
    private static ActionStrategy actionStrategy;

    public ProcessStoreServiceImpl(ActionStrategy actionStrategy) {
        this.actionStrategy = actionStrategy;
    }

    @Override
    public boolean processAction(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            String labelGoods = fruitTransaction.getLabelGoods();
            int value = fruitTransaction.getValue();
            ActionHandler actionHandler = actionStrategy.get(fruitTransaction.getType());
            actionHandler.actionStore(labelGoods, value);
        }
        return true;
    }
}
