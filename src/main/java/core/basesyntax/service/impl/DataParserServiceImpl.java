package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import java.util.ArrayList;
import java.util.List;

public class DataParserServiceImpl implements DataParserService {
    private static final String COMMA = ",";
    private static final int TITLE_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> dataParser(List<String> dataFromFile) {
        dataFromFile.remove(TITLE_INDEX);
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String data : dataFromFile) {
            String[] dataArray = data.split(COMMA);
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(FruitTransaction.Operation
                    .getOperationByCode(dataArray[OPERATION_INDEX]));
            transaction.setFruit(dataArray[FRUIT_INDEX]);
            transaction.setQuantity(Integer.parseInt(dataArray[QUANTITY_INDEX]));
            fruitTransactions.add(transaction);
        }
        return fruitTransactions;
    }
}
