package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitOperationType;
import model.FruitTransaction;
import service.FruitOperationTypeParser;
import service.FruitTransactionParser;
import service.LineSplitter;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int VALUE_INDEX = 2;

    private final LineSplitter lineSplitter = new LineSplitterImpl();
    private final FruitOperationTypeParser fruitOperationTypeParser;

    public FruitTransactionParserImpl(FruitOperationTypeParser fruitOperationTypeParser) {
        this.fruitOperationTypeParser = fruitOperationTypeParser;
    }

    public List<FruitTransaction> parseTransaction(List<String> listOfData) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String lineOfData : listOfData) {
            String[] splitStringOfData = lineSplitter.splitLine(lineOfData);

            FruitOperationType fruitOperationType = fruitOperationTypeParser
                    .getOperationType(splitStringOfData[OPERATION_INDEX]);
            String fruitType = splitStringOfData[FRUIT_TYPE_INDEX];
            Integer integer = Integer.parseInt(splitStringOfData[VALUE_INDEX]);
            fruitTransactionList.add(new FruitTransaction(fruitOperationType, fruitType, integer));
        }
        return fruitTransactionList;
    }
}
