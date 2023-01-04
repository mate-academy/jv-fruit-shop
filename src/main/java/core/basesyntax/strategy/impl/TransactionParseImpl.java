package core.basesyntax.strategy.impl;

import static java.util.stream.Collectors.toList;

import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.strategy.TransactionParse;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class TransactionParseImpl implements TransactionParse {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";
    private static final Integer UPPER_BOUND = 1000;

    @Override
    public List<FruitsTranslation> parseData(List<String> fruitOperations) {
        Predicate<String> nonNullPredicate = Objects::nonNull;
        Predicate<String> transactionPredicate = s -> s
                .split(SEPARATOR)[OPERATION_INDEX].length() == 1
                && Character.isLetter(s.charAt(OPERATION_INDEX))
                && Arrays.stream(FruitsTranslation.Operation.values())
                .anyMatch(o -> o.getCode().equals(s.split(SEPARATOR)[OPERATION_INDEX]));
        Predicate<String> quantityPredicate
                = s -> Integer.parseInt(s.split(SEPARATOR)[QUANTITY_INDEX]) <= UPPER_BOUND;
        return fruitOperations.stream()
                .filter(nonNullPredicate.and(transactionPredicate).and(quantityPredicate))
                .map(s -> createFruitTransaction(s.split(SEPARATOR)))
                .collect(toList());
    }

    private FruitsTranslation createFruitTransaction(String[] splitString) {
        return new FruitsTranslation(FruitsTranslation.Operation
                .getByCode(splitString[OPERATION_INDEX]),
                splitString[FRUIT_INDEX], Integer.parseInt(splitString[QUANTITY_INDEX]));
    }
}
