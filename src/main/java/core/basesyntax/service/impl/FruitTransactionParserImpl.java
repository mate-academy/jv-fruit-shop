package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitTransactionParser;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> toTransactions(List<String> fileData) {
        List<FruitTransaction> transactions = new ArrayList<>();
        Operation id;
        for (String dataString: fileData) {
            String[] separated = dataString.split(SPLITTER);
            id = stringValidator(separated[OPERATION_INDEX].trim());
            if (id != null) {
                transactions.add(new FruitTransaction(id,
                        separated[FRUIT_INDEX], Integer.parseInt(separated[AMOUNT_INDEX])));
            }
        }
        return transactions;
    }

    private Operation stringValidator(String marker) {
        for (Operation id: Operation.values()) {
            if (id.getOperation().equals(marker)) {
                return id;
            }
        }
        return null;
    }
}
