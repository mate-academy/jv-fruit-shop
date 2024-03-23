package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;

import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int INDEX_OF_FIRST_LINE = 0;
    private static final int INDEX_OF_OPERATION_CODE= 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final String SEPARATION_SIGN = ";";

    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        dataFromFile.remove(INDEX_OF_FIRST_LINE);
        List<FruitTransaction> listOfTransactions = new ArrayList<>();
        for (String transaction : dataFromFile) {
            String[] transactionElements = transaction.split(SEPARATION_SIGN);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.getOperationByCode(transactionElements[INDEX_OF_OPERATION_CODE]));
            fruitTransaction.setFruit(transactionElements[INDEX_OF_FRUIT_NAME]);
            fruitTransaction.setQuantity(Integer.parseInt(transactionElements[INDEX_OF_QUANTITY]));
            listOfTransactions.add(fruitTransaction);
        }
        return listOfTransactions;
    }
}
