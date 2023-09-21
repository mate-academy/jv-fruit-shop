package core.basesyntax.service;

import core.basesyntax.data.FruitData;
import core.basesyntax.data.OperationType;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String DELIMITER = ",";

    public List<FruitData> parser(List<String> dataFromFile) {
        List<FruitData> parsed = new ArrayList<>();
        for (int i = 1; i < dataFromFile.size(); i++) {
            FruitData fruitData = new FruitData();
            String[] currentLine = dataFromFile.get(i).split(DELIMITER);
            fruitData.setOperationType(OperationType.getOperation(
                    currentLine[OPERATION_TYPE_INDEX]));
            fruitData.setName(currentLine[FRUIT_NAME_INDEX]);
            fruitData.setQuantity(Integer.parseInt(currentLine[QUANTITY_INDEX]));
            parsed.add(fruitData);
        }
        return parsed;
    }
}
