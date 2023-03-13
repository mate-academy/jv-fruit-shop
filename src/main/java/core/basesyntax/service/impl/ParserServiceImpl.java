package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String COMMA_DELIMITER = ",";
    public static final int OPERATION_TYPE = 0;
    public static final int FRUIT = 1;
    public static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> records) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String record : records) {
            String[] values = record.split(COMMA_DELIMITER);
            if (values[OPERATION_TYPE].equals("type")) {
                continue;
            }
            FruitTransaction.Operation type = Arrays.stream(FruitTransaction.Operation.values())
                    .filter(o -> o.getCode().equals(values[OPERATION_TYPE]))
                    .findFirst()
                    .orElseThrow();
            String fruit = values[FRUIT];
            int quantity = Integer.parseInt(values[QUANTITY]);
            FruitTransaction fruitTransaction = new FruitTransaction(type, fruit, quantity);
            fruitTransactionList.add(fruitTransaction);

        }
        return fruitTransactionList;
    }


}
