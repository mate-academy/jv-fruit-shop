package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int INDEX_TITLE = 0;
    private static final String SPLIT_SYMBOL = ",";

    @Override
    public List<Transaction> parse(List<String> stringList) {
        List<Transaction> fruitRecordsList = new ArrayList<>();
        stringList.remove(INDEX_TITLE);
        for (String fruit : stringList) {
            if (fruit.isBlank()) {
                throw new RuntimeException("Invalid input date: " + fruit);
            }
            String[] split = fruit.split(SPLIT_SYMBOL);
            fruitRecordsList.add(new Transaction(split[OPERATION_INDEX],
                    (split[FRUIT_INDEX]),
                    Integer.parseInt(split[AMOUNT_INDEX])));
        }
        return fruitRecordsList;
    }
}
