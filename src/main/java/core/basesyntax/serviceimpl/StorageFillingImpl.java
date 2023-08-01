package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.HandlerReceiver;
import core.basesyntax.service.StorageFilling;

public class StorageFillingImpl implements StorageFilling {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final String COMA = ",";
    private final HandlerReceiver handlerReceiver = new HandlerReceiverImpl();

    @Override
    public void addToStorage(String[] parsedData, Storage storage) {
        for (String str : parsedData) {
            String[] separatedData = str.split(COMA);
            handlerReceiver
                    .getHandler(separatedData[OPERATION])
                    .updateDB(separatedData[FRUIT],
                            Integer.parseInt(separatedData[QUANTITY]), storage);
        }
    }
}
