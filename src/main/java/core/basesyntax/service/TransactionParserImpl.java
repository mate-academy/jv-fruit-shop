package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final String SPLIT_SYMBOL = ",";
    private static final int INFO_LINE_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getFruitTransactions(List<String> fileData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        fileData.remove(INFO_LINE_INDEX);
        for (String line : fileData) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] lineInfo = line.split(SPLIT_SYMBOL);
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getOperationFromString(lineInfo[OPERATION_INDEX]));
            fruitTransaction.setFruit(lineInfo[FRUIT_NAME_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(lineInfo[FRUIT_QUANTITY_INDEX]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
