package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.HandleErrorsService;
import core.basesyntax.service.InputDataService;
import java.util.List;
import java.util.stream.Collectors;

public class InputDataErrorsServiceImpl implements InputDataService, HandleErrorsService {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUALITY = 2;

    @Override
    public List<FruitTransaction> convertDataToObj(List<String> transactionsData) {
        return transactionsData.stream()
                .skip(1)
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        handleErrors(line.toLowerCase());

        String[] fields = line.split(",");

        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getByOperationType(fields[OPERATION]));
        fruitTransaction.setFruit(fields[FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[QUALITY]));

        return fruitTransaction;
    }

    @Override
    public void handleErrors(String data) {
        String typeHandle = "bspr";
        if (data.contains("null")) {
            throw new RuntimeException("Impossible write data, line - " + data + " contains NULL");
        }

        if (!typeHandle.contains(Character.toString(data.charAt(0)))) {
            throw new RuntimeException("Impossible write data, type - " + data.charAt(0)
                    + " isn't exist");
        }
    }
}
