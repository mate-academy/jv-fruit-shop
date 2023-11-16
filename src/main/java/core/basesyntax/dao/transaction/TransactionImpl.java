package core.basesyntax.dao.transaction;

import core.basesyntax.dao.operation.Operation;
import core.basesyntax.dao.storagedao.FruitStorageDao;
import core.basesyntax.dao.storagedao.FruitStorageDaoImpl;
import java.util.ArrayList;
import java.util.List;

public class TransactionImpl implements Transaction {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int NAME = 1;
    private static final int QUANTITY = 2;

    @Override
    public void getTransactionList(List<String> stringList) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        String[] infoString;
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        for (String str : stringList) {
            infoString = str.split(SEPARATOR);
            if (infoString.length == 3) {
                if (Operation.validAbbreviation(infoString[OPERATION])) {
                    Operation operation = Operation.getOperation(infoString[OPERATION]);
                    String name = infoString[NAME];
                    Integer quantity = Integer.parseInt(infoString[QUANTITY]);

                    fruitStorageDao.add(new FruitTransaction(operation, name, quantity));
                }
            }
        }
    }
}
