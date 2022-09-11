package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final byte DATA_TO_REMOVE_INDEX = 0;
    private static final byte OPERATION_INDEX = 0;
    private static final byte FRUIT_NAME_INDEX = 1;
    private static final byte QUANTITY_INDEX = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<Transaction> getTransactions(List<String> data) {
        data.remove(DATA_TO_REMOVE_INDEX);
        return data.stream()
                .map(s -> s.split(SPLITTER))
                .map(s -> new Transaction(Transaction.Operation.getByCode(s[OPERATION_INDEX]),
                        s[FRUIT_NAME_INDEX], Integer.parseInt(s[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}
