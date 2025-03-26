package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String REGEX = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputFile) {
        if (inputFile == null || inputFile.isEmpty() || inputFile.size() <= 1) {
            return List.of();
        }
        return inputFile.stream()
                .skip(1)
                .map(fileLine -> fileLine.split(REGEX))
                .map(splits -> new FruitTransaction(Operation.operationFromCode(splits[0]),
                        splits[1],
                        Integer.parseInt(splits[2])))
                .toList();
    }
}
