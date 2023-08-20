package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    public static final String COMA_SEPARATOR = ",";
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_NAME_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(COMA_SEPARATOR);
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(FruitTransaction.Operation.getByCode(fields[OPERATION_INDEX]));
        transaction.setFruit(fields[FRUIT_NAME_INDEX]);
        transaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
        return transaction;
    }
}
