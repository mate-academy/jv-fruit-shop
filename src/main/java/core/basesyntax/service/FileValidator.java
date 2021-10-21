package core.basesyntax.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class FileValidator implements DataValidator {
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";

    @Override
    public void validate(List<String> data) {
        List<String> balancedFruit = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] splitLine = data.get(i).split(FruitParserImpl.SEPARATOR);
            checkLine(splitLine);
            String operation = splitLine[0];
            String fruitName = splitLine[1];
            checkOperation(operation);
            checkBalance(balancedFruit, operation, fruitName);
            balancedFruit.add(fruitName);
            checkSequence(balancedFruit, operation, fruitName);
            String quantity = splitLine[2];
            checkQuantity(quantity);

        }
    }

    private void checkSequence(List<String> balancedFruit, String operation, String fruitName) {
        if (!operation.equals(BALANCE) && !balancedFruit.contains(fruitName)) {
            throw new RuntimeException("Incorrect sequence of operations");
        }
    }

    private void checkBalance(List<String> balancedFruit, String operation, String fruitName) {
        if (operation.equals(BALANCE) && balancedFruit.contains(fruitName)) {
            throw new RuntimeException(fruitName + " added to balance again");
        }
    }

    private void checkQuantity(String quantity) {
        if (quantity.startsWith("-")) {
            throw new RuntimeException("Negative quantity: " + quantity);
        }
    }

    private void checkLine(String[] splitLine) {
        if (splitLine.length != 3) {
            throw new RuntimeException("Invalid number of columns; Expected: 3"
                     + ", but was: " + splitLine.length);
        }
    }

    private void checkOperation(String operation) {
        boolean match = Stream.of(BALANCE, SUPPLY, PURCHASE, RETURN)
                .anyMatch(o -> Objects.equals(o, operation));
        if (!match) {
            throw new RuntimeException("Invalid operation" + operation);
        }
    }
}
