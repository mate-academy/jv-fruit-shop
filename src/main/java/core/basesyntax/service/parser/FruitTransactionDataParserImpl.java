package core.basesyntax.service.parser;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.validator.Validator;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionDataParserImpl implements DataParser {
    private static final String CSV_DATA_SEPARATOR = ",";
    private static final int OPERATION_ARRAY_INDEX = 0;
    private static final int FRUIT_ARRAY_INDEX = 1;
    private static final int QUANTITY_ARRAY_INDEX = 2;
    private final Validator validator;

    public FruitTransactionDataParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String dataLine : data) {
            fruitTransactions.add(parseDataToFruitTransaction(dataLine));
        }
        return fruitTransactions;
    }

    private FruitTransaction parseDataToFruitTransaction(String dataLine) {
        String[] data = dataLine.split(CSV_DATA_SEPARATOR);
        String operationType = data[OPERATION_ARRAY_INDEX];
        String fruit = data[FRUIT_ARRAY_INDEX];
        int quantity = Integer.parseInt(data[QUANTITY_ARRAY_INDEX]);
        validator.validate(quantity);
        Operation operation = Operation.fromString(operationType);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
