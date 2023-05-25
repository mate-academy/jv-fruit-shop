package core.basesyntax.service.parser.impl;

import core.basesyntax.enumeration.Operation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.parser.ParserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String SEPARATOR = ",";
    private static final int CODE_OF_OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY_OF_FRUIT = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> sourceData) {
        List<FruitTransaction> resultWithEntities = new ArrayList<>();
        for (int i = 1; i < sourceData.size(); i++) {
            String[] splitString = sourceData.get(i).split(SEPARATOR);
            resultWithEntities
                    .add(new FruitTransaction(getOperation(splitString[CODE_OF_OPERATION].trim()),
                            splitString[FRUIT_NAME],
                            Integer.parseInt(splitString[QUANTITY_OF_FRUIT])));
        }
        return resultWithEntities;
    }

    private Operation getOperation(String string) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getCode().equals(string))
                .findFirst()
                .get();
    }
}
