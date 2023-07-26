package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {
    private static final int INFO_LINE_INDEX = 0;
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int NUMBERS_INDEX = 2;
    private static final String COMMA = ",";

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        lines.remove(INFO_LINE_INDEX);
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] data = line.split(COMMA);
            transactions.add(new FruitTransaction(
                    FruitTransaction.Operation.fromCode(data[OPERATION_TYPE_INDEX]),
                    data[FRUIT_INDEX], Integer.parseInt(data[NUMBERS_INDEX])));
        }
        return transactions;
    }
}
