package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.model.OperationType;
import java.util.ArrayList;
import java.util.List;

public class RecordDtoParserImpl implements RecordDtoParser {
    private static final String COMMA = ",";
    private static final int TITLE = 0;

    @Override
    public List<FruitRecordDto> parse(List<String> dataFromFile) {
        dataFromFile.remove(TITLE);
        List<FruitRecordDto> fruitRecordDtoList = new ArrayList<>(dataFromFile.size());
        for (String line : dataFromFile) {
            String[] data = line.split(COMMA);
            if (line.matches("(.*),(.*),(.*)")) {
                data = line.split(COMMA);
            }
            if (Integer.parseInt(data[2]) < 0) {
                throw new RuntimeException(Integer.parseInt(data[2]) + " is incorrect input.");
            }
            fruitRecordDtoList.add(new FruitRecordDto(new Fruit(data[1]),
                                    Integer.parseInt(data[2]), determinateOperation(data[0])));
        }
        return fruitRecordDtoList;
    }

    private OperationType determinateOperation(String firstLetterOfTypeOperation) {
        switch (firstLetterOfTypeOperation) {
            case "b": {
                return OperationType.BALANCE;
            }
            case "p": {
                return OperationType.PURCHASE;
            }
            case "s": {
                return OperationType.SUPPLY;
            }
            case "r": {
                return OperationType.RETURN;
            }
            default: {
                throw new RuntimeException("Wrong type of operation");
            }
        }
    }
}
