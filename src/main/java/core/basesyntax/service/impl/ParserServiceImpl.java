package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String SEPARATOR = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTUTY = 2;
    private static final int INDEX_TITLE_LINE = 0;

    @Override
    public List<FruitTransaction> parseLines(List<String> lines) {
        List<FruitTransaction> result = new ArrayList<>();
        lines.remove(INDEX_TITLE_LINE);
        for (String line : lines) {
            String[] splitData = line.split(SEPARATOR);
            int quantity = Integer.parseInt(splitData[INDEX_QUANTUTY]);
            Fruit fruit = new Fruit(splitData[INDEX_FRUIT]);
            String operation = splitData[INDEX_OPERATION];
            result.add(new FruitTransaction(operation, fruit, quantity));
        }
        return result;
    }
}
