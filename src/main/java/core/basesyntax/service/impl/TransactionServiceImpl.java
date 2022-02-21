package core.basesyntax.service.impl;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    public static final String BALANCE = "b";
    public static final String SUPPLY = "s";
    public static final String PURCHASE = "p";
    public static final String RETURN = "r";
    private static final String HEAD_OF_INPUT_FILE = "type,fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> createTransactionsList(List<String> inputData) {
        String[] separeitedData;
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        inputData.remove(HEAD_OF_INPUT_FILE);
        for (String data : inputData) {
            separeitedData = data.split(SEPARATOR);
            fruitTransactionList.add(new FruitTransaction(separeitedData[OPERATION_INDEX],
                    separeitedData[FRUIT_NAME_INDEX],
                    Integer.parseInt(separeitedData[QUANTITY_INDEX])));
        }
        return fruitTransactionList;
    }
}
