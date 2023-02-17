package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvTransactionsParser;
import java.util.List;
import java.util.stream.Collectors;

public class CsvTransactionsParserImpl implements CsvTransactionsParser {
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private static final int TITLE_POSITION = 1;
    private static final String DATA_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseTransactions(List<String> transactions) {
        return transactions.stream()
                .skip(TITLE_POSITION)
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLine(String line) {
        String[] data = line.split(DATA_SEPARATOR);
        return new FruitTransaction(
                FruitTransaction.Operation.getByCode(data[OPERATION_POSITION]),
                data[FRUIT_POSITION],
                Integer.parseInt(data[QUANTITY_POSITION]));
    }
}
