package core.basesyntax.service.parser;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;

public class FruitTransactionDataParserImpl implements DataParser {
    private static final String CSV_DATA_SEPARATOR = ",";
    private static final int OPERATION_ARRAY_INDEX = 0;
    private static final int FRUIT_ARRAY_INDEX = 1;
    private static final int QUANTITY_ARRAY_INDEX = 2;
    private final FruitTransactionDao fruitTransactionDao;

    public FruitTransactionDataParserImpl(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void parseData(List<String> data) {
        for (String dataLine : data) {
            fruitTransactionDao.add(parseDataToFruitTransaction(dataLine));
        }
    }

    private FruitTransaction parseDataToFruitTransaction(String dataLine) {
        String[] data = dataLine.split(CSV_DATA_SEPARATOR);
        String operationType = data[OPERATION_ARRAY_INDEX];
        String fruit = data[FRUIT_ARRAY_INDEX];
        int quantity = Integer.parseInt(data[QUANTITY_ARRAY_INDEX]);
        Operation operation = Operation.fromString(operationType);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
