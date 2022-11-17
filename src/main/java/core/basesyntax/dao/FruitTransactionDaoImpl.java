package core.basesyntax.dao;

import core.basesyntax.dbtransaction.FruitTransactionsStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.ReaderFromCsvFile;
import core.basesyntax.services.ReaderFromCsvFileImpl;
import java.util.List;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final String VALUES_SEPARATOR = ",";

    @Override
    public void get(String fileName) {
        ReaderFromCsvFile readerFromCsvFile = new ReaderFromCsvFileImpl();
        List<String> lines = readerFromCsvFile.readFromFile(fileName);
        for (int i = 1; i < lines.size(); i++) {
            String[] split = lines.get(i).split(VALUES_SEPARATOR);
            FruitTransactionsStorage.fruitTransactions
                    .add(new FruitTransaction(FruitTransaction.Operation.getOperationByCode(split[OPERATION]),
                            split[FRUIT],
                            Integer.parseInt(split[QUANTITY])));
        }
    }
}
