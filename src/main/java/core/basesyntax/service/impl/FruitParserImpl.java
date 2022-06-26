package core.basesyntax.service.impl;

import core.basesyntax.model.FruitShopTransactions;
import core.basesyntax.service.FruitParser;
import java.util.ArrayList;
import java.util.List;

public class FruitParserImpl implements FruitParser {
    private static final int TITLE_INDEX = 0;
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    private FruitShopTransactions.Operation getOperationByLetter(String inputOperation) {
        for (FruitShopTransactions.Operation operation : FruitShopTransactions.Operation.values()) {
            if (operation.getOperation().equals(inputOperation)) {
                return operation;
            }
        }
        throw new RuntimeException("Operation " + inputOperation + " not found");
    }
    @Override
    public List<FruitShopTransactions> parse(List<String> lines) {
        lines.remove(TITLE_INDEX);
        List<FruitShopTransactions> parsedLines = new ArrayList<>();
        lines.stream()
                .map(s -> s.split(DATA_SEPARATOR))
                .forEach(s -> parsedLines.add(new FruitShopTransactions(getOperationByLetter(s[OPERATION_INDEX]),
                        s[FRUIT_INDEX],
                        Integer.parseInt(s[QUANTITY_INDEX]))));
        return parsedLines;
    }
}
