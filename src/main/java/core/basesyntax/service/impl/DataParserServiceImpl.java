package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.OperationTypeIdentifier;
import java.util.ArrayList;
import java.util.List;

public class DataParserServiceImpl implements DataParserService {
    private static final String COMMA = ",";
    private static final int FIRST_OPERATION_INDEX = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseFruits(List<String> linesFromInputFile) {
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        OperationTypeIdentifier operationTypeIdentifier = new OperationTypeIdentifierImpl();
        for (int i = FIRST_OPERATION_INDEX; i < linesFromInputFile.size(); i++) {
            String[] fruitTransactionAttributes = linesFromInputFile.get(i).split(COMMA);
            FruitTransaction.Operation operation = operationTypeIdentifier
                    .identifyOperationType(fruitTransactionAttributes[OPERATION_INDEX]);
            String fruit = fruitTransactionAttributes[FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(fruitTransactionAttributes[QUANTITY_INDEX]);
            fruitTransactionsList.add(new FruitTransaction(operation, fruit, quantity));
        }
        return fruitTransactionsList;
    }
}
