package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.Parser;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<Transaction> parse(List<String> transactionInfo) {
        return transactionInfo.stream()
                .skip(1)
                .map(this::getFromFileRow)
                .collect(Collectors.toList());
    }

    private Transaction getFromFileRow(String line) {
        String[] fileInfo = line.split(",");
        return new Transaction(fileInfo[OPERATION_INDEX],
                new Fruit(fileInfo[FRUIT_INDEX]),
                Integer.valueOf(fileInfo[QUANTITY_INDEX]));
    }
}
