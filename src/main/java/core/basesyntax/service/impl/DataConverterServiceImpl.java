package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverterService;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataConverterServiceImpl implements DataConverterService {
    private static final String SPLIT_REGEX = ",";
    private static final String NOT_FOUND_ERR = "No such operation found.";
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final int THIRD_INDEX = 2;

    @Override
    public List<FruitTransaction> getListOfTransactions(List<String> lines) {
        Predicate<String> startsWithValidCode = new Predicate<>() {
            @Override
            public boolean test(String line) {
                return getSetOfPossibleCodes()
                        .contains(String.valueOf(line.charAt(FIRST_INDEX)));
            }
        };

        return lines.stream()
           .filter(startsWithValidCode)
           .map(this::mapToTransaction)
           .collect(Collectors.toList());
    }

    private FruitTransaction mapToTransaction(String line) {
        FruitTransaction transaction = new FruitTransaction();
        String[] parts = line.split(SPLIT_REGEX);

        transaction.setOperation(getOperation(parts[FIRST_INDEX]));
        transaction.setFruit(parts[SECOND_INDEX]);
        transaction.setQuantity(Integer.parseInt(parts[THIRD_INDEX]));

        return transaction;
    }

    private Set<String> getSetOfPossibleCodes() {
        return Arrays.stream(FruitTransaction.Operation.values())
                    .map(FruitTransaction.Operation::getCode)
                    .collect(Collectors.toSet());
    }

    private FruitTransaction.Operation getOperation(String firstLetter) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(operation -> operation.getCode().equalsIgnoreCase(firstLetter))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(NOT_FOUND_ERR));
    }
}
