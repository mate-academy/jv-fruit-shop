package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.List;

public class ParseServiseImpl implements ParseService {
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseLine(List<String> lines) {
        List<FruitTransaction> result = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split(SEPARATOR);
            int quantity = Integer.parseInt(split[2]);
            Fruit fruit = new Fruit(split[1]);
            String operation = split[0];
            result.add(new FruitTransaction(operation, fruit, quantity));
        }
        return result;
    }
}
