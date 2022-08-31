package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String DELIMITER = ",";
    private static final int SPLIT_QUANTITY = 2;
    private static final int SPLIT_FRUIT_NAME = 1;
    private static final int SPLIT_OPERATION_TYPE = 0;
    private static final int FIRST_LINE_INDEX = 0;

    @Override
    public List<Transaction> parse(String data) {
        List<Transaction> list = new ArrayList<>();
        for (String value : data.split(System.lineSeparator())) {
            if (value.equals(data.split(System.lineSeparator())[FIRST_LINE_INDEX])) {
                continue;
            }
            list.add(getTransaction(value));
        }
        return list;
    }

    private Transaction getTransaction(String data) {
        String[] splitted = data.split(DELIMITER);
        return new Transaction(new Fruit(splitted[SPLIT_FRUIT_NAME]),
                Integer.parseInt(splitted[SPLIT_QUANTITY]),
                splitted[SPLIT_OPERATION_TYPE]);
    }
}
