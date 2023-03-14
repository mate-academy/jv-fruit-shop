package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void accept(String data) {
        int indexOfSeparator = data.indexOf(OperationHandler.COMMA_SEPARATOR);
        Storage.STORAGE.put(data.substring(0, indexOfSeparator),
                Integer.valueOf(data.substring(indexOfSeparator + 1)));
    }
}
