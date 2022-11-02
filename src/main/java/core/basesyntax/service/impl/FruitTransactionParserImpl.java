package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.OperationValidator;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE = 0;
    private static final int START_POINT = 1;
    private static final int FRUIT_NAME = 1;
    private static final int COUNT = 2;
    private final OperationValidator operationValidator;

    public FruitTransactionParserImpl(OperationValidator operationValidator) {
        this.operationValidator = operationValidator;
    }

    @Override
    public List<FruitTransaction> parseFruitTransactions(List<String> list) {
        String[] parseData;
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = START_POINT; i < list.size(); i++) {
            parseData = list.get(i).split(SEPARATOR);
            fruitTransactionList.add(new FruitTransaction(
                    operationValidator.validate(parseData[OPERATION_TYPE]),
                    new Fruit(parseData[FRUIT_NAME]), Integer.parseInt(parseData[COUNT])));
        }
        return fruitTransactionList;
    }
}
