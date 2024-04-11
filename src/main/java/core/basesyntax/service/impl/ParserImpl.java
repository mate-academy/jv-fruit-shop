package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {
    public static final String WORD_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        return data.stream()
                .filter(line -> line.startsWith("b")
                        || line.startsWith("s")
                        || line.startsWith("p")
                        || line.startsWith("r"))
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(WORD_SEPARATOR);
        if (fields.length < 3) {
            throw new RuntimeException("Null value presents in line: " + line);
        }
        if (fields.length > 3) {
            throw new RuntimeException("Redundant value presents in line: " + line);
        }
        FruitTransaction fruitTransaction = new FruitTransaction();
        try {
            FruitTransaction.Operation operation = FruitTransaction.Operation.BALANCE;
            operation = operation.getOperationFromLetter(fields[0]);
            fruitTransaction.setOperation(operation);
            fruitTransaction.setFruit(fields[1]);
            fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid value presents in line: " + line);
        }
        return fruitTransaction;
    }
}
