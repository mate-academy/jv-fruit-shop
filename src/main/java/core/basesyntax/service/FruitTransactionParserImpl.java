package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    public static final String SEPARATE_SYMBOL_FOR_CSV = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    public FruitTransactionParserImpl() {
    }

    public List<Transaction> parseList(List<String> transactionListString) {
        return transactionListString.stream()
                .map(s -> s.split(SEPARATE_SYMBOL_FOR_CSV))
                .map(t -> new Transaction(Operation.getByCode(t[OPERATION_INDEX]),
                        t[FRUIT_INDEX],
                        Integer.parseInt(t[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }
}
