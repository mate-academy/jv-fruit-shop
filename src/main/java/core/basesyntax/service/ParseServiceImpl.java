package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;

public class ParseServiceImpl implements ParseService {
    private static final String COMMA = ",";

    @Override
    public FruitRecord getParsedLine(String row) {
        String[] rowData = row.split((COMMA));
        if (rowIsValid(rowData)) {
            FruitRecord.Operation operation = FruitRecord.getOperationByFirstLetter(rowData[0].charAt(0));
            String fruitName = rowData[1];
            int fruitAmount = Integer.parseInt(rowData[2]);
            return new FruitRecord(operation, fruitName, fruitAmount);
        }
        throw new RuntimeException("Data '" + row + "' in row is not valid.");
    }

    private boolean rowIsValid(String[] rowData) {
        return rowData.length == 3;
    }
}
