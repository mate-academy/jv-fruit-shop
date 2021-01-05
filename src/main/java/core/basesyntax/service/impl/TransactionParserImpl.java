package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final String WORD_SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final String TABLE_HEADER = "type";

    @Override
    public List<TransactionDto> parse(List<String> lines) {
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        if (lines.get(0).startsWith(TABLE_HEADER)) {
            lines.remove(0);
        }
        try {
            for (String line : lines) {
                String[] data = line.split(WORD_SEPARATOR);
                transactionDtoList
                        .add(new TransactionDto(Operation.getOperationFromString(data[OPERATION]),
                                new Fruit(data[FRUIT_NAME]),
                                Integer.parseInt(data[QUANTITY])));
            }
            return transactionDtoList;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new RuntimeException("File with incorrect data");
        }
    }
}
