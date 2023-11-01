package service.impl;

import java.util.ArrayList;
import model.FruitTransaction;
import model.FruitTransaction.OperationType;
import service.ReadedDataParser;

public class CsvReadedDataParser implements ReadedDataParser {
    private static final String SPLIT_REGEX = ",";

    @Override
    public ArrayList<FruitTransaction> convertToFruitTransactionList(ArrayList<String> fileLines) {
        ArrayList<FruitTransaction> operationsList = new ArrayList<>();
        for (int i = 1; i < fileLines.size(); i++) {
            String[] splitedLine = fileLines.get(i).split(SPLIT_REGEX);
            String operationTypeCode = splitedLine[0];
            String fruitType = splitedLine[1];
            int quantity = Integer.parseInt(splitedLine[2]);
            operationsList.add(new FruitTransaction(OperationType.valueOf(operationTypeCode),
                fruitType, quantity));
        }
        return operationsList;
    }
}
