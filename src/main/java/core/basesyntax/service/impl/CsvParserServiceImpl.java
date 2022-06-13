package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvParserService;

public class CsvParserServiceImpl implements CsvParserService<FruitTransaction> {
    private static final String RECORD_REGEX = "[bspr],[a-zA-Z]+,[0-9]+";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public FruitTransaction parse(String line) {
        if (!line.matches(RECORD_REGEX)) {
            throw new RuntimeException("Invalid input format");
        }
        String[] lineData = line.split(",");
        return new FruitTransaction(lineData[TYPE_INDEX], lineData[FRUIT_INDEX],
                Integer.parseInt(lineData[QUANTITY_INDEX]));
    }
}
