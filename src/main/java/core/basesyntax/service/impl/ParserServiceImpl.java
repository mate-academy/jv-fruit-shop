package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileParserService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements FileParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMMA = ",";
    private static final int HEADER = 1;

    @Override
    public List<FruitTransaction> getFruitTransaction(List<String> fruitsDataFromFile) {
        return fruitsDataFromFile.stream()
                .skip(HEADER)
                .map(dataLine -> dataLine.split(COMMA))
                .map(splittedLine -> new FruitTransaction(getOperationFromSplittedLine(
                        splittedLine[OPERATION_INDEX]),
                        splittedLine[FRUIT_NAME_INDEX],
                        Integer.parseInt(splittedLine[QUANTITY_INDEX])))
                    .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getOperationFromSplittedLine(String operationType) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(o -> o.getOperation().equals(operationType))
                .findFirst()
                .get();
    }
}
