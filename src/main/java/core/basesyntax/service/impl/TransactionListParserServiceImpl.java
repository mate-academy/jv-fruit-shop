package core.basesyntax.service.impl;

import static java.util.stream.Collectors.toList;

import core.basesyntax.model.Product;
import core.basesyntax.service.TransactionListParserService;
import core.basesyntax.strategy.FruitTransaction;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TransactionListParserServiceImpl implements TransactionListParserService {
    private static final String SEPARATOR = ",";
    private static final int PRODUCT_INDEX = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int AMOUNT_INDEX = 2;
    private static final int COLUMN_QUANTITY = 3;

    @Override
    public List<FruitTransaction> parse(List<String> input) {
        validateInput(input);
        return input.stream()
                .map(this::parseLine)
                .filter(Objects::nonNull)
                .collect(toList());
    }

    private FruitTransaction parseLine(String input) {
        if (Arrays.stream(FruitTransaction.Operation.values())
                .noneMatch(o -> isEqualsIgnoreCase(input, OPERATION_INDEX, o.getCode()))
                || Arrays.stream(Product.values())
                .noneMatch(p -> isEqualsIgnoreCase(input, PRODUCT_INDEX, p.name()))) {
            return null;
        }
        FruitTransaction.Operation operation = Arrays.stream(FruitTransaction.Operation.values())
                .filter(o -> isEqualsIgnoreCase(input, OPERATION_INDEX, o.getCode()))
                .findFirst()
                .get();
        Product product = Arrays.stream(Product.values())
                .filter(p -> isEqualsIgnoreCase(input, PRODUCT_INDEX, p.name()))
                .findFirst()
                .get();
        int quantity = Integer.parseInt(input.split(SEPARATOR)[AMOUNT_INDEX]);
        return new FruitTransaction(operation, product, quantity);
    }

    private boolean isEqualsIgnoreCase(String input, int operationIndex, String o) {
        return input.split(SEPARATOR)[operationIndex].equalsIgnoreCase(o);
    }

    private void validateInput(List<String> input) {
        if (input == null) {
            throw new RuntimeException("Not accepted null argument in class: "
                    + getClass().getSimpleName());
        }
        if (input.stream()
                .anyMatch(s -> s.split(SEPARATOR).length != COLUMN_QUANTITY)) {
            throw new RuntimeException("Not available input string's format, expected: ["
                    + COLUMN_QUANTITY + "] columns, but get: ["
                    + input.stream().mapToInt(s -> s.split(SEPARATOR).length).findFirst().getAsInt()
                    + "] columns");
        }
    }
}
