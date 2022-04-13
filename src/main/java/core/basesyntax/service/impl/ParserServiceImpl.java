package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int HEADER_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMMA = ",";
    private final Predicate<String> validator;

    public ParserServiceImpl(Predicate<String> validator) {
        this.validator = validator;
    }

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        lines.remove(HEADER_INDEX);
        return lines.stream()
                .filter(validator)
                .map(this::createTransactionFromLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction createTransactionFromLine(String line) {
        String[] data = line.split(COMMA);
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(getOperationByValue(data[OPERATION_INDEX]));
        transaction.setFruit(new Fruit(data[FRUIT_INDEX]));
        transaction.setQuantity(Integer.parseInt(data[QUANTITY_INDEX]));
        return transaction;
    }

    private FruitTransaction.Operation getOperationByValue(String value) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(o -> o.getOperation().equals(value))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unsupported operation: " + value));
    }
}
