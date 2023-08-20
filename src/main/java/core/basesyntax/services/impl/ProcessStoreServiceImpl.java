package core.basesyntax.services.impl;

import core.basesyntax.exception.ValidationDataException;
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
        if (fruitTransactions == null) {
            throw new ValidationDataException("Process error. "
                    + "List of fruit transactions can't be null");
        }
        if (fruitTransactions.isEmpty()) {
            throw new ValidationDataException("Process error. "
                    + "List of fruit transactions can't be empty");
        }

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            String labelGoods = fruitTransaction.getLabelGoods();
            int value = fruitTransaction.getValue();
            ActionHandler actionHandler = actionStrategy.get(fruitTransaction.getType());
            actionHandler.executeAction(labelGoods, value);
        }
        return true;
    }
}
