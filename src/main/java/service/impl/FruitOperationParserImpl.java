package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitOperationType;
import model.FruitTransaction;
import service.FruitOperationParser;
import service.FruitOperationTypeParser;
import service.LineSplitter;

public class FruitOperationParserImpl implements FruitOperationParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int VALUE_INDEX = 2;

    private final LineSplitter lineSplitter = new LineSplitterImpl();
    private final List<FruitTransaction> fruitTransactionList = new ArrayList<>();
    private final FruitOperationTypeParser fruitOperationTypeParser;

    public FruitOperationParserImpl(FruitOperationTypeParser fruitOperationTypeParser) {
        this.fruitOperationTypeParser = fruitOperationTypeParser;
    }

    public List<FruitTransaction> parseFruitOperationList(List<String> listOfData) {
        for (java.lang.String lineOfData: listOfData) {
            java.lang.String[] splitStringOfData = lineSplitter.splitLine(lineOfData);

            FruitOperationType fruitOperationType = fruitOperationTypeParser
                    .checkAndGetOperationType(splitStringOfData[OPERATION_INDEX]);
            String fruitType = splitStringOfData[FRUIT_TYPE_INDEX];
            Integer integer = Integer.parseInt(splitStringOfData[VALUE_INDEX]);
            fruitTransactionList.add(new FruitTransaction(fruitOperationType, fruitType, integer));
        }
        return fruitTransactionList;
    }
}
