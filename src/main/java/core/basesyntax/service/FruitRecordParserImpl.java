package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordParserImpl implements FruitRecordParser {
    public static final int OPERATION_TYPE = 0;
    public static final int FRUIT_NAME = 1;
    public static final int FRUIT_AMOUNT = 2;
    private FruitRecord newFruitRecord;
    private String[] lineArray;
    private List<FruitRecord> fruitRecordList = new ArrayList<>();

    @Override
    public List<FruitRecord> parserFruitRecords(List<String> fileLines) {
        InputDataValidator<String> inputDataValidator = new InputDataValidatorImpl();
        for (String fileLine : fileLines) {
            try {
                lineArray = inputDataValidator.validate(fileLine);
            } catch (InputDataErrorException exc) {
                throw new RuntimeException("Fruit Records is not valid" + fileLine, exc);
            }
            newFruitRecord = new FruitRecord(lineArray[OPERATION_TYPE],
                    lineArray[FRUIT_NAME], Integer.parseInt(lineArray[FRUIT_AMOUNT]));
            fruitRecordList.add(newFruitRecord);
        }
        return fruitRecordList;
    }
}
