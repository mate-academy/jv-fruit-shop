package core.basesyntax.service;

import core.basesyntax.dto.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    private static final String SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String OPERATION_BALANCE = "b";
    private static final String OPERATION_SUPPLY = "s";
    private static final String OPERATION_RETURN = "r";
    private static final String OPERATION_PURCHASE = "p";
    private static final int NUMBER_OF_ELEMENTS_TO_SKIP = 1;
    private DataValidator validator = new DataValidatorImpl();

    @Override
    public List<Transaction> parseToTransactionList(List<String> data) {
        return data.stream()
                .skip(NUMBER_OF_ELEMENTS_TO_SKIP)
                .map(s -> s.split(SPLITTER))
                .filter(validator::dataIsValid)
                .map(this::createTransaction)
                .collect(Collectors.toList());
    }

    private Transaction createTransaction(String[] strings) {
        return new Transaction(getOperation(strings[OPERATION_INDEX]), strings[FRUIT_NAME_INDEX],
                Integer.parseInt(strings[QUANTITY_INDEX]));
    }

    private Transaction.Operation getOperation(String splitDatum) {
        switch (splitDatum) {
            case OPERATION_BALANCE:
                return Transaction.Operation.B;
            case OPERATION_PURCHASE:
                return Transaction.Operation.P;
            case OPERATION_RETURN:
                return Transaction.Operation.R;
            case OPERATION_SUPPLY:
            default:
                return Transaction.Operation.S;
        }
    }
}
