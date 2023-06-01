package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String SEPARATOR = ",";
    private static final int CODE_OF_OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY_OF_FRUIT = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> sourceData) {
        return sourceData.stream()
                .map(t -> {
                    String[] splitString = t.split(SEPARATOR);
                    return new FruitTransaction(
                            FruitTransaction.Operation.getOperation(splitString[CODE_OF_OPERATION]),
                            splitString[FRUIT_NAME],
                            Integer.parseInt(splitString[QUANTITY_OF_FRUIT])
                    );
                })
                .collect(Collectors.toList());
    }
}
