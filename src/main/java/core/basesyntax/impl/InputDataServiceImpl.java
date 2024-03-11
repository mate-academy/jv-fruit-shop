package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.InputDataService;
import java.util.List;
import java.util.stream.Collectors;

public class InputDataServiceImpl implements InputDataService {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUALITY = 2;
    private static final String SEPARATOR = ",";
    private static final int OFFSET = 1;

    @Override
    public List<FruitTransaction> convertDataToObj(List<String> transactionsData) {
        return transactionsData.stream()
                .skip(OFFSET)
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        handleErrors(line.toLowerCase());

        String[] fields = line.split(SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();

        fruitTransaction.setOperation(FruitTransaction.Operation
                .getByOperationType(fields[OPERATION]));
        fruitTransaction.setFruit(fields[FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[QUALITY]));

        return fruitTransaction;
    }

    private void handleErrors(String data) {
        if (data.contains("null")) {
            throw new RuntimeException("Impossible write data, line - " + data + " contains NULL");
        }
    }
}
