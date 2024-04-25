package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitOperation;
import model.FruitOperationType;
import model.FruitType;
import service.FruitOperationParser;
import service.FruitOperationTypeParser;
import service.FruitTypeParser;
import service.LineSplitter;

public class FruitOperationParserImpl implements FruitOperationParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int VALUE_INDEX = 2;

    private final LineSplitter lineSplitter = new LineSplitterImpl();
    private final List<FruitOperation> fruitOperationList = new ArrayList<>();
    private final FruitOperationTypeParser fruitOperationTypeParser;
    private final FruitTypeParser fruitTypeParser;

    public FruitOperationParserImpl(FruitOperationTypeParser fruitOperationTypeParser,
                                    FruitTypeParser fruitTypeParser) {
        this.fruitOperationTypeParser = fruitOperationTypeParser;
        this.fruitTypeParser = fruitTypeParser;
    }

    public List<FruitOperation> parseFruitOperationList(List<String> listOfData) {
        for (String lineOfData: listOfData) {
            String[] splitStringOfData = lineSplitter.splitLine(lineOfData);

            FruitOperationType fruitOperationType = fruitOperationTypeParser
                    .checkAndGetOperationType(splitStringOfData[OPERATION_INDEX]);
            FruitType fruitType = fruitTypeParser
                    .checkAndGetFruitType(splitStringOfData[FRUIT_TYPE_INDEX]);
            Integer integer = Integer.parseInt(splitStringOfData[VALUE_INDEX]);
            fruitOperationList.add(new FruitOperation(fruitOperationType, fruitType, integer));
        }
        return fruitOperationList;
    }
}
