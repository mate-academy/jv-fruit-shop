package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileDataParser;
import java.util.List;
import java.util.stream.Collectors;

public class FileDataParserImpl implements FileDataParser {

    private static final String DIVIDER = ",";
    private static final int REQUIRED_LENGTH = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<Transaction> parse(List<String> data) {
        return data.stream()
                .skip(1)
                .map(this::parseTransaction)
                .collect(Collectors.toList());
    }

    private Transaction parseTransaction(String data) {
        String[] dataArray = data.split(DIVIDER);
        if (dataArray.length != REQUIRED_LENGTH) {
            throw new IllegalArgumentException("Invalid transaction data format");
        }

        String operation = dataArray[OPERATION_INDEX];
        String name = dataArray[NAME_INDEX];
        int quantity = Integer.parseInt(dataArray[QUANTITY_INDEX]);
        return new Transaction(operation, name, quantity);
    }
}
