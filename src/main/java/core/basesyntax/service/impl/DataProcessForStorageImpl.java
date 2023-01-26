package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessForStorageService;
import java.util.List;

public class DataProcessForStorageImpl implements DataProcessForStorageService {
    private static final int FIRST_TRANSACTION_INDEX = 1;
    private static final String SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();

    @Override
    public void processReadData(List<String> readData) {
        if (readData == null || readData.isEmpty()) {
            throw new RuntimeException("Incorrect data file");
        }
        for (int i = FIRST_TRANSACTION_INDEX; i < readData.size(); i++) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] splitReadData = readData.get(i).split(SPLITTER);
            String transactionOperation = splitReadData[OPERATION_INDEX].trim();
            String fruitName = splitReadData[FRUIT_NAME_INDEX].trim();
            int transactionAmount = Integer.parseInt(splitReadData[AMOUNT_INDEX]);
            fruitTransaction
                    .setOperation(FruitTransaction.Operation.getBySymbol(transactionOperation));
            fruitTransaction.setFruit(fruitName);
            fruitTransaction.setQuantity(transactionAmount);
            fruitTransactionDao.add(fruitTransaction);
        }
    }
}
