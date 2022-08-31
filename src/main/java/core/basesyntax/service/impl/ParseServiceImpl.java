package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.List;

public class ParseServiceImpl implements ParseService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String REGEX = ",";

    @Override
    public List<Transaction> parse(List<String> lines) {
        List<Transaction> parsedLines = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split(REGEX);
            String operation = split[OPERATION_INDEX];
            Fruit fruit = new Fruit(split[FRUIT_INDEX]);
            int quantity = Integer.parseInt(split[QUANTITY_INDEX]);
            parsedLines.add(new Transaction(operation, fruit, quantity));
        }
        return parsedLines;
    }
}
