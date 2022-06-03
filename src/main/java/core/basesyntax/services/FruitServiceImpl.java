package core.basesyntax.services;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final int OPERATION_VALUE_INDEX = 0;
    private static final int FRUIT_VALUE_INDEX = 1;
    private static final int QUANTITY_VALUE_INDEX = 2;
    private static final String TITLE_STRING_OF_FILE = "type,fruit,quantity";
    private StorageDao storageDao;

    public FruitServiceImpl() {
        this.storageDao = new StorageDaoImpl();
    }

    public void addUniqueFruitsToStorage(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction: transactions) {
            if (transaction.getOperation().equals(FruitTransaction.Operation.BALANCE)) {
                storageDao.add(transaction.getFruit(), transaction.getQuantity());
            }
        }
    }

    public List<FruitTransaction> getListOfTransactions(List<String> inputFromFile) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        FruitTransaction transaction;
        for (String input: inputFromFile) {
            if (input.equals(TITLE_STRING_OF_FILE)) {
                continue;
            }
            String[] valueToMath = input.split(",");
            transaction = new FruitTransaction(FruitTransaction.Operation
                    .findOperation(valueToMath[OPERATION_VALUE_INDEX]),
                    valueToMath[FRUIT_VALUE_INDEX],
                    Integer.parseInt(valueToMath[QUANTITY_VALUE_INDEX]));
            fruitTransactionList.add(transaction);
        }
        return fruitTransactionList;
    }
}
