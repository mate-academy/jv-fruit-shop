package core.basesyntax.service.implementions;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.RecordDtoParser;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecordDtoParserImpl implements RecordDtoParser {
    private static final String COMMA = ",";
    private static final long TITLE = 1;

    @Override
    public List<FruitRecordDto> parse(List<String> dataFromFile) {
        List<FruitRecordDto> fruitRecordDtoList = new ArrayList<>();
        List<String> ignoredTitle = dataFromFile.stream()
                                            .skip(TITLE)
                                            .collect(Collectors.toList());
        for (String line : ignoredTitle) {
            String[] data = line.split(COMMA);
            if (data.length != 3) {
                throw new RuntimeException("Incorrect input");
            }
            int quantity = Integer.parseInt(data[2]);
            if (quantity < 0) {
                throw new RuntimeException(quantity + " is incorrect input.");
            }
            fruitRecordDtoList.add(new FruitRecordDto(new Fruit(data[1]),
                                    quantity, determinateOperation(data[0])));
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
