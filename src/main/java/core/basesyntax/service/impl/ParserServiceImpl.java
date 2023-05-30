package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseData(List<String> lines) {
        return lines.stream()
                .map(line -> {
                    String[] splitLine = line.split(SEPARATOR);
                    return new FruitTransaction(FruitTransaction.Operation
                            .getOperationByCode(splitLine[OPERATION_INDEX]),
                            splitLine[FRUIT_INDEX],
                            Integer.parseInt(splitLine[QUANTITY_INDEX]));
                })
        .collect(Collectors.toList());
    }
}
