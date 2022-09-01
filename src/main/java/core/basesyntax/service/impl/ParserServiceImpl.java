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
        for (int i = 1; i < data.split(System.lineSeparator()).length; i++) {
            list.add(getTransaction(data.split(System.lineSeparator())[i]));
        }
        return list;
    }

    private Transaction getTransaction(String data) {
        String[] splitData = data.split(DELIMITER);
        return new Transaction(new Fruit(splitData[SPLIT_FRUIT_NAME]),
                Integer.parseInt(splitData[SPLIT_QUANTITY]),
                splitData[SPLIT_OPERATION_TYPE]);
    }
}
