package core.basesyntax.service.transaction.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.transaction.FruitTransactionParsingService;
import java.util.ArrayList;
import java.util.List;

public class CsvFruitTransactionParsingService implements FruitTransactionParsingService {
    private static final String CSV_SEPARATOR = ",";
    private static final int FRUIT_TRANSACTION_OPERATION_INDEX = 0;
    private static final int FRUIT_TRANSACTION_FRUIT_INDEX = 1;
    private static final int FRUIT_TRANSACTION_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(String data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] dataLines = data.split(System.lineSeparator());
        for (int i = 1; i < dataLines.length; i++) {
            String[] parts = dataLines[i].split(CSV_SEPARATOR);
            fruitTransactions.add(new FruitTransaction(
                    FruitTransaction.Operation.ofCode(parts[FRUIT_TRANSACTION_OPERATION_INDEX]),
                    parts[FRUIT_TRANSACTION_FRUIT_INDEX],
                    Integer.parseInt(parts[FRUIT_TRANSACTION_QUANTITY_INDEX])
            ));
        }
        return fruitTransactions;
    }
}
