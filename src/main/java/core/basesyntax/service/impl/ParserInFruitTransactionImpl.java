package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserInFruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ParserInFruitTransactionImpl implements ParserInFruitTransaction {
    public static final String COMA_SEPARATOR = ",";
    private static final int HEADLINES_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        data.remove(HEADLINES_INDEX);
        return data.stream()
                .map(this::parseRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseRow(String row) {
        String[] separateRow = row.split(COMA_SEPARATOR);
        return new FruitTransaction(FruitTransaction.Operation
                .getOperation(separateRow[OPERATION_INDEX]),
                separateRow[FRUIT_NAME_INDEX],
                Integer.parseInt(separateRow[QUANTITY_INDEX]));
    }
}
