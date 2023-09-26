package core.basesyntax.service;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.data.OperationType;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String DELIMITER = ",";

    public List<FruitTransaction> parser(List<String> dataFromFile) {
        List<FruitTransaction> parsed = new ArrayList<>();
        for (int i = 1; i < dataFromFile.size(); i++) {
            FruitTransaction fruitData = new FruitTransaction();
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
