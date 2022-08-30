package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.List;

public class ParseServiseImpl implements ParseService {
    private static final String SEPARATOR = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTUTY = 2;

    @Override
    public List<FruitTransaction> parseLine(List<String> lines) {
        List<FruitTransaction> result = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split(SEPARATOR);
            int quantity = Integer.parseInt(split[INDEX_QUANTUTY]);
            Fruit fruit = new Fruit(split[INDEX_FRUIT]);
            String operation = split[INDEX_OPERATION];
            result.add(new FruitTransaction(operation, fruit, quantity));
        }
        return result;
    }
}
