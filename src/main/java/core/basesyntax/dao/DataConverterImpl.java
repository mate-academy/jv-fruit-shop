package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputFile) {
        if (inputFile == null && inputFile.size() <= 1) {
            return List.of();
        }
        return inputFile.stream()
                .skip(1)
                .map(fileLine -> fileLine.split(","))
                .map(splits -> new FruitTransaction(Operation.operationFromCode(splits[0]),
                        splits[1],
                        Integer.parseInt(splits[2])))
                .collect(Collectors.toList());
    }
}
