package core.basesyntax.service.impl;

import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ParserService;

import java.util.List;

public class ParserServiceImpl implements ParserService {
    private final int OPERATION_CODE_INDEX;
    private final int QUANTITY_INDEX;
    private final int FRUIT_NAME_INDEX;

    private final FruitTransactionService fruitTransactionService;

    public ParserServiceImpl() {
        OPERATION_CODE_INDEX = 0;
        QUANTITY_INDEX = 2;
        FRUIT_NAME_INDEX = 1;
        fruitTransactionService = new FruitTransactionServiceImpl();
    }

    @Override
    public void parseData(List<String> inputDataRows) {
        for (int i = 1; i < inputDataRows.size(); i++) {
            String[] entryData = inputDataRows.get(i).split(",");
            String operationCode = entryData[OPERATION_CODE_INDEX];
            String fruit = entryData[FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(entryData[QUANTITY_INDEX].trim());
            fruitTransactionService.createFruitTransaction(operationCode, fruit, quantity);
        }
    }
}
