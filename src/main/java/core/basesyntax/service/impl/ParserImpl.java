package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final String DELIMITER = ",";
    private static final String REGEX = "^[brsp],[a-zA-Z]+,[0-9]+$";
    private static final String STORE_HEADER = "type,fruit,quantity";
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public FruitTransaction parse(String data) {
        if (!data.matches(REGEX)) {
            throw new RuntimeException("Transaction \"" + data + "\" can not be parsed");
        }
        try {
            String[] strings = data.split(DELIMITER);
            String fruitName = strings[NAME_INDEX];
            int quantity = Integer.parseInt(strings[QUANTITY_INDEX]);
            Operation operation = Operation
                    .fromCode(strings[OPERATION_INDEX]);
            return new FruitTransaction(operation, fruitName, quantity);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing transaction \"" + data + "\"");
        }
    }

    @Override
    public List<FruitTransaction> convertFruitDataToTransactions(List<String> fruitData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String data : fruitData) {
            if (!data.equals(STORE_HEADER)) {
                FruitTransaction fruitTransaction = parse(data);
                fruitTransactions.add(fruitTransaction);
            }
        }
        return fruitTransactions;
    }
}
