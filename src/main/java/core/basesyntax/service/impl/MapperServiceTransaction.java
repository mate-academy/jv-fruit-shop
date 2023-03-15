package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.MapperService;

public class MapperServiceTransaction implements MapperService<String, FruitTransaction> {
    private final int operationCodeColumn;
    private final int fruitColumn;
    private final int amountColumn;
    private final String csvSeparator;

    public MapperServiceTransaction(int operationCodeColumn,
                                    int fruitColumn,
                                    int amountColumn,
                                    String csvSeparator) {
        this.operationCodeColumn = operationCodeColumn;
        this.fruitColumn = fruitColumn;
        this.amountColumn = amountColumn;
        this.csvSeparator = csvSeparator;
    }

    @Override
    public FruitTransaction map(String from) {
        final String[] parsed = from.split(csvSeparator);
        return new FruitTransaction(
                parsed[operationCodeColumn],
                parsed[fruitColumn],
                Integer.parseInt(parsed[amountColumn]));
    }
}
