package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.OperationType;
import core.basesyntax.service.ReadDataParser;
import java.util.ArrayList;
import java.util.List;

public class CsvReadDataParserImpl implements ReadDataParser {
    private static final String SPLIT_REGEX = ",";

    @Override
    public ArrayList<FruitTransaction> convertToFruitTransactionList(List<String> fileLines) {
        ArrayList<FruitTransaction> operationsList = new ArrayList<>();
        for (int i = 1; i < fileLines.size(); i++) {
            String[] splitedLine = fileLines.get(i).split(SPLIT_REGEX);
            String operationTypeCode = splitedLine[0];
            String fruitType = splitedLine[1];
            int quantity = Integer.parseInt(splitedLine[2]);
            OperationType operationType = OperationType.fromCode(operationTypeCode);
            operationsList.add(new FruitTransaction(operationType, fruitType, quantity));
        }
        return operationsList;
    }
}
