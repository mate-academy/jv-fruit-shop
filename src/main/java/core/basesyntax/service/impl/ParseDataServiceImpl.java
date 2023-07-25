package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseDataService;

import java.util.ArrayList;
import java.util.List;

public class ParseDataServiceImpl implements ParseDataService {
    private static final String REGEX = ",";
    private static final int TITLE_INDEX = 0;
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseFile(List<String> dataFromFile) {
        dataFromFile.remove(TITLE_INDEX);
        List<FruitTransaction> transactionsList = new ArrayList<>();

        for (String str : dataFromFile) {
            String[] dataArray = str.split(REGEX);
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(FruitTransaction.Operation.getOperation(dataArray[TYPE_INDEX]));
            transaction.setFruit(dataArray[FRUIT_INDEX]);
            transaction.setQuantity(Integer.parseInt(dataArray[QUANTITY_INDEX]));
            transactionsList.add(transaction);
        }
        return transactionsList;
    }
}
