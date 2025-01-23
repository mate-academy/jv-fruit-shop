package core.basesyntax.converter;

import core.basesyntax.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        if (inputReport == null) {
            throw new NullPointerException("Input report must not be null");
        }
        List<FruitTransaction> convertedData = new ArrayList<>();
        for (String line : inputReport) {
            String[] lineList = line.split(",");
            FruitTransaction.Operation operation = getOperation(lineList[0]);
            if (operation != null) {
                convertedData.add(
                        new FruitTransaction(operation, lineList[1], Integer.parseInt(lineList[2]))
                );
            }
        }
        return convertedData;
    }

    private FruitTransaction.Operation getOperation(String operationType) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operationType.startsWith(operation.getCode())) {
                return operation;
            }
        }
        return null;
    }
}
