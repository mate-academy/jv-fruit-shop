package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitTransactionParserServiceImpl implements FruitTransactionParserService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> parse(List<String> list) {
        List<FruitTransaction> parsedTransactions = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            String[] splitData = list.get(i).split(SPLITTER);
            FruitTransaction.Operation operation = getOperation(splitData[OPERATION_TYPE_INDEX]);
            String fruitName = splitData[FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(splitData[QUANTITY_INDEX]);
            parsedTransactions.add(new FruitTransaction(operation, new Fruit(fruitName), quantity));
        }
        return parsedTransactions;
    }

    private FruitTransaction.Operation getOperation(String operationLetter) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(o -> o.getOperation().equals(operationLetter))
                .findFirst().orElseThrow(() ->
                        new RuntimeException("Don't have this kind of operation "
                                + operationLetter));
    }
}
