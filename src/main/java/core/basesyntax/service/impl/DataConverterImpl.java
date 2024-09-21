package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FruitConverter;
import core.basesyntax.service.exceptions.InvalidDataException;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final int NUMBER_OF_COLUMNS = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .map(a -> a.trim())
                .map(a -> a.split(","))
                .filter(a -> isDataCorrect(a))
                .map(el -> {
                    if (isInteger(el[2].trim())) {
                        FruitTransaction transaction = new FruitTransaction();
                        transaction.setOperation(FruitTransaction.Operation.fromCode((el[0])));
                        transaction.setFruit(FruitConverter.convertToFruit(el[1]));
                        transaction.setQuantity(Integer.valueOf(el[2]));
                        return transaction;
                    } else {
                        return null;
                    }
                })
                .collect(Collectors.toList());
    }

    private boolean isDataCorrect(String[] line) {
        if (line.length != NUMBER_OF_COLUMNS) {
            throw new InvalidDataException("Invalid data: numbers of column should be: "
            + NUMBER_OF_COLUMNS
            + "but was: " + line.length + ".");
        }
        return true;
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
