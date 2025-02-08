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
                .map(s -> s.split(SEPARATOR))
                .filter(s -> s.length == 3 && isNumeric(s[2]))
                .map(string -> new FruitTransaction(
                        FruitTransaction.getOperation(string[OPERATION_INDEX]),
                        string[FRUIT_NAME_INDEX], Integer.parseInt(string[CAPACITY_INDEX])))
                .toList();
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
