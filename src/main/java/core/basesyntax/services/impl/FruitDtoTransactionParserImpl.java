package core.basesyntax.services.impl;

import core.basesyntax.model.OperationType;
import core.basesyntax.model.dtos.FruitDtoTransaction;
import core.basesyntax.services.interfaces.FruitDtoTransactionParser;
import java.util.ArrayList;
import java.util.List;

public class FruitDtoTransactionParserImpl implements FruitDtoTransactionParser {
    private static final String SPLIT_REGEX = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OPERATION_TYPE_LENGTH = 1;

    @Override
    public List<FruitDtoTransaction> parse(List<String> lines) {
        List<FruitDtoTransaction> fruitDtoTransactions = new ArrayList<>(lines.size());
        for (String line : lines) {
            String[] record = line.split(SPLIT_REGEX);
            if (record[OPERATION_TYPE_INDEX].length() == OPERATION_TYPE_LENGTH) {
                fruitDtoTransactions.add(new FruitDtoTransaction(
                        OperationType.getOperationType(record[OPERATION_TYPE_INDEX]),
                        (record[FRUIT_NAME_INDEX]),
                        Integer.parseInt(record[QUANTITY_INDEX])));
            }
        }
        return fruitDtoTransactions;
    }
}
