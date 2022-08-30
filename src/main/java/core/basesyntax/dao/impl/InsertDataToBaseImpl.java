package core.basesyntax.dao.impl;

import core.basesyntax.dao.InsertDataToBase;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.List;

public class InsertDataToBaseImpl implements InsertDataToBase {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;

    @Override
    public void addTransferToStorage(List<String> dataFromBase) {
        String[] parsedData;
        for (int i = 1; i < dataFromBase.size(); i++) {
            parsedData = dataFromBase.get(i).split(",");
            Storage.transactions.add(new Transaction(parsedData[OPERATION],
                    new Fruit(parsedData[FRUIT_NAME]),
                    Integer.parseInt(parsedData[QUANTITY])));
        }
    }
}
