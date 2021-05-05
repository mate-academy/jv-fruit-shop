package core.basesyntax.service.implementions;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.RecordDtoParser;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecordDtoParserImpl implements RecordDtoParser {
    private static final String CSV_SEPARATOR = ",";
    private static final long TITLE_ROW = 1;
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final int VALID_SIZE = 3;

    @Override
    public List<FruitRecordDto> parse(List<String> dataFromFile) {
        List<FruitRecordDto> fruitRecordDtoList = new ArrayList<>();
        List<String> records = dataFromFile.stream()
                                            .skip(TITLE_ROW)
                                            .collect(Collectors.toList());
        for (String line : records) {
            String[] data = line.split(CSV_SEPARATOR);
            if (data.length != VALID_SIZE) {
                throw new RuntimeException("Incorrect input");
            }
            int quantity = Integer.parseInt(data[QUANTITY]);
            if (quantity < 0) {
                throw new RuntimeException(quantity + " is incorrect input.");
            }
            fruitRecordDtoList.add(new FruitRecordDto(new Fruit(data[FRUIT]),
                                    quantity, determinateOperation(data[OPERATION_TYPE])));
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
