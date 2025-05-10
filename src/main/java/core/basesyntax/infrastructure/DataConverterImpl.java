package core.basesyntax.infrastructure;

import core.basesyntax.service.FruitTransaction;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int CAPACITY_INDEX = 2;
    private static final int CAPACITY_LESS_VALUE = 0;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .map(line -> line.split(SEPARATOR))
                .map(dataArray -> new FruitTransaction(
                        FruitTransaction.getOperation(dataArray[OPERATION_INDEX]),
                        dataArray[FRUIT_NAME_INDEX], getCapacityValue(dataArray[CAPACITY_INDEX])))
                .toList();
    }

    private Integer getCapacityValue(String str) {
        int value;
        try {
            value = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid number format: '"
                    + str + "'. Expected an integer value.");
        }
        if (value >= CAPACITY_LESS_VALUE) {
            return value;
        }
        throw new RuntimeException("Error! Number can't be less than zero");
    }
}
