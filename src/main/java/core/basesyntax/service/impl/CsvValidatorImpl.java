package core.basesyntax.service.impl;

import core.basesyntax.model.OperationType;
import core.basesyntax.service.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvValidatorImpl implements Validator {
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final String INPUT_DATA_HEAD = "type,fruit,quantity";
    private static final String LINE_PATTERN = "[a-z],[a-z]+,[0-9]+";
    private final List<String> shortOperation;

    {
        shortOperation = new ArrayList<>();
        initShortOperation();
    }

    @Override
    public boolean isValid(List<String> inputData) {
        if (inputData.isEmpty() || !inputData.get(0).equals(INPUT_DATA_HEAD)) {
            throw new RuntimeException("Invalid input data");
        }

        inputData.stream()
                .skip(1)
                .forEach(line -> {
                    if (!isValidLine(line)) {
                        throw new RuntimeException("Invalid input data, try again");
                    }
                });
        return true;
    }

    private boolean isValidLine(String line) {
        return line.matches(LINE_PATTERN)
            && shortOperation.contains(String.valueOf(line.charAt(ACTIVITY_TYPE_INDEX)))
            && line.charAt(line.lastIndexOf(',') + 1) != '-';
    }

    private void initShortOperation() {
        Arrays.stream(OperationType.values())
                .forEach(operationType -> shortOperation.add(operationType.getOperation()));
    }
}
