package core.basesyntax.service;

import core.basesyntax.exception.FruitException;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserService {
    private static final String SEPARATOR = ",";
    private static final int OPERATOR_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int COUNT_WORDS = 3;
    private static final String ANNOTATION = "type,fruit,quantity";

    public List<FruitTransaction> parse(List<String> strings) {
        if (strings == null) {
            throw new FruitException("Incoming string list is null");
        }
        strings = clearAnnotationCsvFile(strings);
        return strings.stream()
                .map(this::getFromString)
                .collect(Collectors.toList());
    }

    private List<String> clearAnnotationCsvFile(List<String> strings) {
        return strings.stream()
                .filter(s -> !ANNOTATION.equals(s))
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromString(String string) {
        String [] partsTransaction = string.split(SEPARATOR);
        checkPartsTransaction(partsTransaction);
        return new FruitTransaction(
                FruitTransaction.Operation.getOperationByCode(partsTransaction[OPERATOR_INDEX]),
                partsTransaction[FRUIT_INDEX],
                Integer.parseInt(partsTransaction[AMOUNT_INDEX]));
    }

    private void checkPartsTransaction(String[] partsTransaction) {
        if (partsTransaction.length != COUNT_WORDS) {
            throw new FruitException("The entry in the file should consist of " + COUNT_WORDS
                    + " parts, separated by \"" + SEPARATOR + "\". Found "
                    + partsTransaction.length + "part(s)");
        }
        if (partsTransaction[FRUIT_INDEX].isBlank()) {
            throw new FruitException("The entry in the file must contain fruit value");
        }
        int amount;
        try {
            amount = Integer.parseInt(partsTransaction[AMOUNT_INDEX]);
        } catch (NumberFormatException e) {
            throw new FruitException("Invalid number format for amount's value");
        }
        if (amount < 0) {
            throw new FruitException("Amount value cannot be negative");
        }
    }
}
