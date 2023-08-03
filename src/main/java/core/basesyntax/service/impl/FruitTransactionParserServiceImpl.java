package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionParserService;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserServiceImpl implements TransactionParserService {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String COMA_SPLITTER = ",";
    private static final int INDEX_OF_OPERATIONS_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final int INDEX_OF_BEGINNING_OF_TRANSANTIONS = 1;

    @Override
    public List<FruitTransaction> getListOfTransactions(String dataFromFile) {
        List<FruitTransaction> transactions = new ArrayList<>();
        String[] records = dataFromFile.split(LINE_SEPARATOR);
        for (int i = INDEX_OF_BEGINNING_OF_TRANSANTIONS; i < records.length; i++) {
            String[] record = records[i].split(COMA_SPLITTER);
            Operation operationType = Operation.getOperationType(record[INDEX_OF_OPERATIONS_TYPE]);
            String nameOfFruit = record[INDEX_OF_FRUIT_TYPE];
            Integer quantityOfFruit = Integer.parseInt(record[INDEX_OF_QUANTITY]);
            transactions.add(new FruitTransaction(operationType,nameOfFruit,quantityOfFruit));
        }
        return transactions;
    }
}
