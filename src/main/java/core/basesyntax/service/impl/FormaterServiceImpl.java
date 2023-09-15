package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FormaterService;
import java.util.ArrayList;
import java.util.List;

public class FormaterServiceImpl implements FormaterService {

    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLITERATOR = ",";

    @Override
    public List<FruitTransaction> format(List<String> stringList) {
        return createFormatedList(stringList);
    }

    private List<FruitTransaction> createFormatedList(List<String> stringList) {
        List<FruitTransaction> transactionsList = new ArrayList<>();
        for (String line: stringList) {
            String[] splitedLine = line.split(SPLITERATOR);
            transactionsList.add(
                    new FruitTransaction(
                            Operation.getOperationByCode(splitedLine[OPERATION_INDEX]),
                            splitedLine[FRUIT_NAME_INDEX],
                            Integer.parseInt(splitedLine[QUANTITY_INDEX])));
        }
        return transactionsList;
    }
}
