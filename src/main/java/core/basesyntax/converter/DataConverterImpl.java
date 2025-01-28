package core.basesyntax.converter;

import core.basesyntax.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        if (inputReport == null) {
            throw new RuntimeException("Input report must not be null");
        }
        List<FruitTransaction> convertedData = new ArrayList<>();
        for (String line : inputReport) {
            String[] lineList = line.split(SEPARATOR);
            if (lineList[0].length() == 1) {
                FruitTransaction.Operation operation = FruitTransaction.getOperationFromType(
                        lineList[0]
                );
                convertedData.add(
                        new FruitTransaction(operation, lineList[1], Integer.parseInt(lineList[2]))
                );
            }
        }
        return convertedData;
    }
}
