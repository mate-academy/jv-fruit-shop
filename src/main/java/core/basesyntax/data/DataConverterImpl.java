package core.basesyntax.data;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> readReport) {
        List<FruitTransaction> fruitReport = new ArrayList<>();
        for (String line : readReport) {
            String[] value = line.split(SEPARATOR);
            if (value.length != 3) {
                throw new IllegalArgumentException("There should be 3 values in line and not: "
                        `+ value.length);
            }
            try {
                fruitReport.add(new FruitTransaction(
                        FruitTransaction.Operation.fromCode(value[OPERATION_INDEX]),
                        value[FRUIT_INDEX],
                        Integer.parseInt(value[QUANTITY_INDEX])));
            } catch (RuntimeException e) {
                throw new IllegalArgumentException(
                        "Line should be in pattern: \"type,fruit,quantity\" ");
            }

        }
        return fruitReport;
    }
}
