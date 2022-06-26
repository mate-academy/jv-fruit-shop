package core.basesyntax.service.impl;

import core.basesyntax.model.FruitShopTransactions;
import core.basesyntax.service.FruitParser;

import java.util.ArrayList;
import java.util.List;

public class FruitParserImpl implements FruitParser {
    private static final int TITLE_INDEX  = 0;
    private static final String COMA  = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitShopTransactions> parse(List<String> lines) {
        lines.remove(TITLE_INDEX);
        List<FruitShopTransactions> parsedLines = new ArrayList<>();
        lines.stream()
                .map(s -> s.split(COMA))
                .forEach(s -> parsedLines.add(new FruitShopTransactions(FruitShopTransactions
                        .getOperationByLetter(s[OPERATION_INDEX]),
                        s[FRUIT_INDEX],
                        Integer.parseInt(s[QUANTITY_INDEX]))));
        return parsedLines;
    }
}
