package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvParserService;

public class CsvParserServiceImpl implements CsvParserService<FruitTransaction> {
    private static final String RECORD_REGEX = "[bspr],[a-zA-Z]+,[0-9]+";

    @Override
    public FruitTransaction parseLine(String line) {
        if (!line.matches(RECORD_REGEX)) {
            throw new RuntimeException("Invalid input format");
        }
        String[] strings = line.split(",");
        return new FruitTransaction(strings[0], strings[1],
                Integer.parseInt(strings[2]));
    }
}
