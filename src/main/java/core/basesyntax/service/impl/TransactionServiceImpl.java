package core.basesyntax.service.impl;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private static final String HEAD_OF_INPUT_FILE = "type,fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> createTransactionsList(List<String> inputData) {
        String[] separatedData;
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        inputData.remove(HEAD_OF_INPUT_FILE);
        for (String data : inputData) {
            separatedData = data.split(SEPARATOR);
            fruitTransactionList.add(new FruitTransaction(separatedData[OPERATION_INDEX],
                    separatedData[FRUIT_NAME_INDEX],
                    Integer.parseInt(separatedData[QUANTITY_INDEX])));
        }
        return fruitTransactionList;
    }
}
