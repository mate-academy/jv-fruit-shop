package service.impl;

import fruitscontent.FruitsContent;
import java.util.ArrayList;
import java.util.List;
import service.ParserOperationService;

public class ParserOperationServiceImpl implements ParserOperationService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int POINT_TO_START_READING = 1;

    @Override
    public List<FruitsContent> parseContentForOperations(List<String> inputData) {
        List<FruitsContent> parsedData = new ArrayList<>();
        for (int i = POINT_TO_START_READING; i < inputData.size(); i++) {
            parsedData.add(parseInputData(inputData.get(i)));
        }
        return parsedData;
    }

    private FruitsContent parseInputData(String line) {
        FruitsContent fruitsContent = new FruitsContent();
        String[] separetedLine = line.split(",");
        fruitsContent.setOperation(FruitsContent.Operation
                .getByCode(separetedLine[OPERATION_INDEX]));
        fruitsContent.setFruit(separetedLine[FRUIT_INDEX]);
        fruitsContent.setQuantity(Integer.parseInt(separetedLine[QUANTITY_INDEX]));
        return fruitsContent;
    }
}
