package core.basesyntax.service;

import core.basesyntax.dto.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    private static final String SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int NUMBER_OF_ELEMENTS_TO_SKIP = 1;
    private DataValidator validator;

    public ParserImpl(DataValidator validator) {
        this.validator = validator;
    }

    @Override
    public List<Transaction> parseToTransactionList(List<String> data) {
        return data.stream()
                .skip(NUMBER_OF_ELEMENTS_TO_SKIP)
                .map(s -> s.split(SPLITTER))
                .filter(validator::isValid)
                .map(this::createTransaction)
                .collect(Collectors.toList());
    }

    private Transaction createTransaction(String[] strings) {
        return new Transaction(Transaction.Operation.valueOf(strings[OPERATION_INDEX]
                .toUpperCase()), strings[FRUIT_NAME_INDEX],
                Integer.parseInt(strings[QUANTITY_INDEX]));
    }
}

