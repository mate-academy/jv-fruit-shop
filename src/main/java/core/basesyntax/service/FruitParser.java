package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FruitParser {
    private static final String REGEX_COMMA = ",";

    public List<FruitTransaction> parseLinesInFile(List<String> linesInFile) {
        Function<String[], FruitTransaction> stringsToFruitTransaction = params -> {
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(Operation.getOperationByCode(params[0]));
            fruitTransaction.setFruit(params[1]);
            fruitTransaction.setQuantity(Integer.parseInt(params[2]));
            return fruitTransaction;
        };
        return linesInFile.stream()
                .skip(1)
                .map(line -> line.split(REGEX_COMMA))
                .map(stringsToFruitTransaction)
                .collect(Collectors.toList());
    }
}
