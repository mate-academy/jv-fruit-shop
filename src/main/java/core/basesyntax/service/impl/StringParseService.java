package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class StringParseService implements ParserService<String> {
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String DIVIDER = ",";
    private final List<FruitTransaction> result = new ArrayList<>();

    @Override
    public List<FruitTransaction> parse(List<String> linesFromFile) {
        FruitTransaction fruitTransaction;
        for (String line : linesFromFile) {
            if (!line.trim().startsWith("t")) {
                String[] splitLine = line.trim().split(DIVIDER);
                fruitTransaction = new FruitTransaction(
                        FruitTransaction.Operation.findByCode(splitLine[OPERATION_INDEX]),
                        splitLine[NAME_INDEX],
                        Integer.parseInt(splitLine[QUANTITY_INDEX]));
                result.add(fruitTransaction);
            }
        }
        return result;
    }
}
