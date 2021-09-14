package core.basesyntax.service.impl;

import core.basesyntax.db.HandlerStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final String COMMA = ",";
    private static final int OPERATION_DATA_INDEX = 0;
    private static final int FRUIT_NAME_DATA_INDEX = 1;
    private static final int FRUIT_AMOUNT_DATA_INDEX = 2;
    private static final int DATA_ARRAY_LENGTH = 3;
    private static final int OPERATION_LENGTH = 1;

    @Override
    public FruitRecord getParsedLine(String row) {
        String[] rowData = row.split((COMMA));
        if (rowIsValid(rowData)) {
            FruitRecord.Operation operation = HandlerStorage
                    .getOperationByFirstLetter(rowData[OPERATION_DATA_INDEX].charAt(0));
            String fruitName = rowData[FRUIT_NAME_DATA_INDEX];
            int fruitAmount = Integer.parseInt(rowData[FRUIT_AMOUNT_DATA_INDEX]);
            return new FruitRecord(operation, new Fruit(fruitName), fruitAmount);
        }
        throw new RuntimeException("Data '" + row + "' in row is not valid.");
    }

    private boolean rowIsValid(String[] rowData) {
        return rowData.length == DATA_ARRAY_LENGTH
                && rowData[OPERATION_DATA_INDEX].length() == OPERATION_LENGTH
                && rowData[FRUIT_NAME_DATA_INDEX].length() > 0
                && Integer.parseInt(rowData[FRUIT_AMOUNT_DATA_INDEX]) >= 0;
    }
}
