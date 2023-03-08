package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.service.CalculationService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculationServiceImpl implements CalculationService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public void initializationStorage(List<String> convertedFileIntoList) {
        List<String[]> separatedData = separateData(convertedFileIntoList);
        Map<String, Integer> startBalance = separatedData.stream()
                .filter(i -> i[OPERATION_INDEX].equals(Operation.BALANCE.getCode()))
                .collect(Collectors.toMap(i -> i[FRUIT_INDEX],
                        i -> Integer.parseInt(i[AMOUNT_INDEX])));
        Storage.setStorage(startBalance);
    }

    @Override
    public void calculation(List<String> convertedFileIntoList) {
        List<String[]> separatedData = separateData(convertedFileIntoList);
        for (String[] transaction : separatedData) {
            if (transaction[OPERATION_INDEX].equals(Operation.SUPPLY.getCode())) {
                int tempAmount = Integer.parseInt(transaction[AMOUNT_INDEX])
                        + Storage.getStorage().get(transaction[FRUIT_INDEX]);
                Storage.getStorage().put(transaction[FRUIT_INDEX], tempAmount);
            } else if (transaction[OPERATION_INDEX].equals(Operation.RETURN.getCode())) {
                int tempAmount = Integer.parseInt(transaction[AMOUNT_INDEX])
                        + Storage.getStorage().get(transaction[FRUIT_INDEX]);
                Storage.getStorage().put(transaction[FRUIT_INDEX], tempAmount);
            } else if (transaction[OPERATION_INDEX].equals(Operation.PURCHASE.getCode())) {
                int amount = Storage.getStorage().get(transaction[FRUIT_INDEX])
                        - Integer.parseInt(transaction[AMOUNT_INDEX]);
                Storage.getStorage().put(transaction[FRUIT_INDEX], amount);
            }
        }
    }

    private List<String[]> separateData(List<String> data) {
        return data.stream()
                .map(i -> i.split(","))
                .collect(Collectors.toList());
    }
}
