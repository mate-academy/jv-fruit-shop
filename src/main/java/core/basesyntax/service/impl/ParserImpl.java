package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLITERATOR = ",";

    @Override
    public List<Transaction> parse(List<String> data) {
        data.remove(OPERATION_INDEX);
        List<Transaction> parsedData = new ArrayList<>();
        data.stream()
                .map(s -> s.split(SPLITERATOR))
                .forEach(strings -> parsedData.add(
                        new Transaction(Transaction.findOperationByName(
                                strings[OPERATION_INDEX]),
                                strings[FRUIT_NAME_INDEX],
                                Integer.parseInt(strings[QUANTITY_INDEX]))));
        return parsedData;
    }
}
