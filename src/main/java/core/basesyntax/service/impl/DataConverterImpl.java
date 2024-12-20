package core.basesyntax.service.impl;

import core.basesyntax.models.FruitTransfer;
import core.basesyntax.models.Operation;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransfer> convertToTransfer(List<String> inputReport) {
        List<FruitTransfer> transferList = new ArrayList<>();
        List<String[]> collectedLinesInfo = inputReport.stream()
                .map(s -> s.split(","))
                .skip(1)
                .toList();

        for (String[] line : collectedLinesInfo) {
            Operation operations = Operation.getOperations(line[OPERATION_INDEX]);
            String fruit = line[FRUIT_INDEX];
            int quantity = Integer.parseInt(line[AMOUNT_INDEX]);
            transferList.add(new FruitTransfer(operations, fruit, quantity));
        }
        return transferList;
    }
}
