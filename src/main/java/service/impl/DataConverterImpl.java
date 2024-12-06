package service.impl;

import core.basesyntax.FruitTransfer;
import core.basesyntax.Operation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransfer> convertToTransfer(List<String> inputReport) {
        List<FruitTransfer> transferList = new ArrayList<>();
        List<String[]> collectedLinesInfo = inputReport.stream()
                .map(s -> s.split(","))
                .collect(Collectors.toList());

        for (String[] line : collectedLinesInfo) {
            Operation operations = Operation.getOperations(line[0]);
            String fruit = line[1];
            int quantity = Integer.parseInt(line[2]);
            transferList.add(new FruitTransfer(operations, fruit, quantity));
        }
        return transferList;
    }
}
