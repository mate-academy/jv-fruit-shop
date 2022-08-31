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

    @Override
    public List<Transaction> parse(String data) {
        List<Transaction> list = new ArrayList<>();
        for (String value : data.split(System.lineSeparator())) {
            list.add(normalize(value));
        }
        return list;
    }

    private Transaction normalize(String data) {
        String fruitName;
        String operationType;
        int quantity;
        quantity = Integer.parseInt(data.split(DELIMITER)[SPLIT_QUANTITY].trim());
        fruitName = data.split(DELIMITER)[SPLIT_FRUIT_NAME].trim();
        operationType = data.split(DELIMITER)[SPLIT_OPERATION_TYPE].trim();
        return new Transaction(new Fruit(fruitName), quantity, operationType);
    }
}
