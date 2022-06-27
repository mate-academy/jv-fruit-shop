package core.basesyntax.service.impl;

import core.basesyntax.model.FruitShopTransactions;
import core.basesyntax.service.FruitParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitParserImpl implements FruitParser {
    private static final int TITLE_INDEX = 0;
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    private FruitShopTransactions.Operation getOperationByLetter(String inputOperation) {
        return Arrays.stream(FruitShopTransactions.Operation.values())
                .filter(operation -> operation.getOperation().equals(inputOperation))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Operation "
                        + inputOperation
                        + " not found"));
    }

    @Override
    public List<FruitShopTransactions> parse(List<String> lines) {
        lines.remove(TITLE_INDEX);
        return lines.stream()
                .map(s -> s.split(DATA_SEPARATOR))
                    .map(s -> {
                        return new FruitShopTransactions(getOperationByLetter(
                        s[OPERATION_INDEX]),
                        s[FRUIT_INDEX],
                        Integer.parseInt(s[QUANTITY_INDEX]));
                    })
                .collect(Collectors.toList());
    }
}
