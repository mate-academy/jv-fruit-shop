package core.basesyntax.dao.transaction;

import core.basesyntax.dao.operation.Operation;
import core.basesyntax.dao.storagedao.FruitStorageDao;
import core.basesyntax.db.FruitStorage;

import java.util.ArrayList;
import java.util.List;

public class TransactionImpl implements Transaction {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int NAME = 1;
    private static final int QUANTITY = 2;
    private FruitStorageDao fruitStorageDao;
    @Override
    public void getTransactionList(List<String> stringList) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        String[] infoString;
        for (String str : stringList) {
            infoString = str.split(SEPARATOR);
            if (infoString.length == 3) {
                if (Operation.validAbbreviation(infoString[OPERATION])) {
                    Operation operation = Operation.valueOf(infoString[OPERATION]);
                    String name = infoString[NAME];
                    Integer quantity = Integer.parseInt(infoString[QUANTITY]);

                    fruitStorageDao.add(new FruitTransaction(operation, name, quantity));
                }
            }
        }
    }
}
