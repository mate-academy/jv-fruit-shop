package core.basesyntax.infrastructure;

import core.basesyntax.service.FruitTransaction;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int CAPACITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .map(line -> line.split(SEPARATOR))
                .filter(dataArray -> dataArray.length == 3 && isNumeric(dataArray[2]))
                .map(dataArray -> new FruitTransaction(
                        FruitTransaction.getOperation(dataArray[OPERATION_INDEX]),
                        dataArray[FRUIT_NAME_INDEX], Integer.parseInt(dataArray[CAPACITY_INDEX])))
                .toList();
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid number format: '"
                    + str + "'. Expected an integer value.");
        }
    }
}
