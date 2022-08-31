package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMMA = ",";

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
            .skip(1)
            .map(l -> convertToFruitTransaction(l))
            .collect(Collectors.toList());
    }

    private FruitTransaction convertToFruitTransaction(String line) {
        String[] resultLine = line.split(COMMA);
        return new FruitTransaction(
                resultLine[OPERATION_INDEX],
                new Fruit(resultLine[FRUIT_INDEX]),
                Integer.parseInt(resultLine[QUANTITY_INDEX]));
    }
}
