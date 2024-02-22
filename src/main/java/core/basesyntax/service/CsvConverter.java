package core.basesyntax.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvConverter implements Convertable {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;
    private static final String EXP_HEADER = "type,fruit,quantity";
    private static final String EXP_FORMAT = "b,";

    public List<OperationData> convertToRecord(String dataFromFile) {
        String cleanText = dataFromFile.replaceAll(" +", "");

        if (!cleanText.startsWith(EXP_HEADER
                + System.lineSeparator() + EXP_FORMAT)) {
            throw new RuntimeException("Input file must start with: " + System.lineSeparator()
                    + "\"" + EXP_HEADER + "\"" + System.lineSeparator()
                    + "\"" + EXP_FORMAT + "\" for current balance");
        }

        return Arrays.stream(cleanText.replaceAll(" +", "")
                        .split(System.lineSeparator()))
                .skip(1)
                .map(line -> line.split(","))
                .map(values -> new OperationData(
                        values[OPERATION_INDEX],
                        values[FRUIT_TYPE_INDEX],
                        Integer.parseInt(values[FRUIT_AMOUNT_INDEX].trim())
                ))
                .collect(Collectors.toList());
    }

    public record OperationData(String operation, String fruitType, int quantity) {
    }
}
