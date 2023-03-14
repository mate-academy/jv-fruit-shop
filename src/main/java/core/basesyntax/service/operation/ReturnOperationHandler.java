package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void accept(String data) {
        int indexOfSeparator = data.indexOf(OperationHandler.COMMA_SEPARATOR);
        int amount = Storage.STORAGE.get(data.substring(0, indexOfSeparator));
        Storage.STORAGE.put(data.substring(0, indexOfSeparator),
                amount + Integer.parseInt(data.substring(indexOfSeparator + 1)));
    }
}
