package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;
import java.util.function.Function;

public class FruitParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String REGEX_COMMA = ",";

    public List<FruitTransaction> parseLinesInFile(List<String> linesInFile) {
        Function<String[], FruitTransaction> stringsToFruitTransaction = params -> {
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(Operation.getOperationByCode(params[OPERATION_INDEX]));
            fruitTransaction.setFruit(params[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(params[QUANTITY_INDEX]));
            return fruitTransaction;
        };
        return linesInFile.stream()
                .skip(1)
                .map(line -> line.split(REGEX_COMMA))
                .map(stringsToFruitTransaction)
                .toList();
    }
}
