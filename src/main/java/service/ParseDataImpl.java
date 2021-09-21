package service;

import java.util.ArrayList;
import java.util.List;
import model.FruitRecord;

public class ParseDataImpl implements ParseData {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int FRUIT_QUANTITY = 2;
    private Validator validator = new ValidatorImpl();

    public List<FruitRecord> recordingData(List<String[]> splitedInformationList) {
        validator.validate(splitedInformationList);
        List<FruitRecord> operationList = new ArrayList<>();
        String[] splitLine;
        int amount;
        for (int i = 1; i < splitedInformationList.size(); i++) {
            splitLine = splitedInformationList.get(i);
            amount = Integer.parseInt(splitLine[FRUIT_QUANTITY]);
            operationList.add(new FruitRecord(splitLine[OPERATION_TYPE],
                    splitLine[FRUIT_TYPE], amount));
        }
        return operationList;
    }
}
