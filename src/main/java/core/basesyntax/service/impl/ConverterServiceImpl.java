package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConverterService;
import java.util.Arrays;

public class ConverterServiceImpl implements ConverterService {
    private static final String DELIMITER = ",";

    @Override
    public FruitTransaction convertStringToFruitTransaction(String transaction) {
        String[] fields = transaction.split(DELIMITER);
        FruitTransaction.Operation operation = getOperationByCode(fields[0]);
        int amount;
        try {
            amount = Integer.parseInt(fields[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Parsing " + fields[2] + " to integer failed");
        }
        return new FruitTransaction(operation, fields[1], amount);
    }

    public FruitTransaction.Operation getOperationByCode(String code) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(value -> value.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Code " + code + " not found"));
    }
}
