package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void accept(String data) {
        int indexOfSeparator = data.indexOf(OperationHandler.COMMA_SEPARATOR);
        Storage.STORAGE.put(data.substring(0, indexOfSeparator),
                Integer.valueOf(data.substring(indexOfSeparator + 1)));
    }
}
