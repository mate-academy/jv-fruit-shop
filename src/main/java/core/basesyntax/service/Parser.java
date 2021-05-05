package core.basesyntax.service;

import static core.basesyntax.service.Operation.fromString;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import java.util.ArrayList;
import java.util.List;

public class Parser implements ParseToList {
    public static final int OPERATION = 0;
    public static final int FRUIT = 1;
    public static final int QUANTITY = 2;
    public static final String COMMA = ",";

    @Override
    public List<FruitRecordDto> parseToDto(List<String> dataFromFile) {
        if (dataFromFile.isEmpty()) {
            throw new RuntimeException(String.format("No data in the file %s", dataFromFile));
        }
        List<FruitRecordDto> convertedToTransaction = new ArrayList<>();
        for (String value : dataFromFile) {
            String[] splitData = value.split(COMMA);
            convertedToTransaction.add(new FruitRecordDto(fromString(splitData[OPERATION]),
                    new Fruit(splitData[FRUIT]), Integer.valueOf(splitData[QUANTITY])));
        }
        return convertedToTransaction;
    }
}
