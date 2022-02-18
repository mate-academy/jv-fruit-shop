package fruitshop.service.impl;

import fruitshop.db.TransactionStorage;
import fruitshop.model.FruitTransaction;
import fruitshop.model.Operation;
import fruitshop.service.file.WriteDataToStorageService;

public class WriteDataToStorageImpl implements WriteDataToStorageService {
    private static final String SEPARATOR = ",";
    private static final int INDEX_TYPE_TRANSACTION = 0;
    private static final int INDEX_NAME_TRANSACTION = 1;
    private static final int INDEX_SUM_TRANSACTION = 2;
    private static final int MAXIMUM_TRANSACTION_LENGTH = 1;
    private final TransactionStorage transactionStorage = new TransactionStorage();

    @Override
    public void writeData(String dataLine) {
        if (!checkFirstLine(dataLine)) {
            transactionStorage.add(parseTransaction(dataLine));
        }
    }

    private FruitTransaction parseTransaction(String dataLine) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] currentLineDate = dataLine.split(SEPARATOR);
        fruitTransaction.setFruit(currentLineDate[INDEX_NAME_TRANSACTION]);
        fruitTransaction.setQuantity(Integer.parseInt(currentLineDate[INDEX_SUM_TRANSACTION]));
        Operation operation = Operation.parse(currentLineDate[INDEX_TYPE_TRANSACTION]);
        fruitTransaction.setOperation(operation);
        return fruitTransaction;
    }

    private boolean checkFirstLine(String dataLine) {
        String[] line = dataLine.split(SEPARATOR);
        return line[INDEX_TYPE_TRANSACTION].length() > MAXIMUM_TRANSACTION_LENGTH;
    }
}
