package service.impl;

import java.util.ArrayList;
import java.util.List;
import models.FruitTransaction;
import service.Parser;

public class ParserImpl implements Parser {

    private static final String COMMA_LINE_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String line: dataFromFile) {
            String[] lineInfo = line.split(COMMA_LINE_SEPARATOR);
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.getOperationFromString(lineInfo[OPERATION_INDEX]);
            FruitTransaction fruit = new FruitTransaction(operation,
                    lineInfo[FRUIT_NAME_INDEX], Integer.parseInt(lineInfo[FRUIT_QUANTITY_INDEX]));
            fruitTransactionList.add(fruit);
        }
        return fruitTransactionList;
    }
}
