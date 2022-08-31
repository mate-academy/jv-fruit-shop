package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String REGEX = ",";
    private static final int INDEX_TITLE_LINE = 0;

    @Override
    public List<Transaction> parse(List<String> lines) {
        List<Transaction> parsedLines = new ArrayList<>();
        lines.remove(INDEX_TITLE_LINE);
        for (String line : lines) {
            String[] splitData = line.split(REGEX);
            String operation = splitData[OPERATION_INDEX];
            Fruit fruit = new Fruit(splitData[FRUIT_INDEX]);
            int quantity = Integer.parseInt(splitData[QUANTITY_INDEX]);
            parsedLines.add(new Transaction(operation, fruit, quantity));
        }
        return parsedLines;
    }
}
