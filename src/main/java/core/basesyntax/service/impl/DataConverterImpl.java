package core.basesyntax.service.impl;

import core.basesyntax.FruitTransfer;
import core.basesyntax.Operation;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransfer> convertToTransfer(List<String> inputReport) {
        List<FruitTransfer> transferList = new ArrayList<>();
        List<String[]> collectedLinesInfo = inputReport.stream()
                .map(s -> s.split(","))
                .skip(1)
                .toList();

        for (String[] line : collectedLinesInfo) {
            Operation operations = Operation.getOperations(line[0]);
            String fruit = line[1];
            int quantity = Integer.parseInt(line[2]);
            transferList.add(new FruitTransfer(operations, fruit, quantity));
        }
        return transferList;
    }

    public String convertToStringFormat(List<String> listReport) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : listReport) {
            stringBuilder.append(line).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
