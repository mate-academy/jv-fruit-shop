package core.basesyntax.service.transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int BEGINNING_OF_THE_LIST = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getFruitTransaction(List<String> transactionData) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = BEGINNING_OF_THE_LIST; i < transactionData.size(); i++) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] splitString = transactionData.get(i).split(",");
            fruitTransaction.setOperation(FruitTransaction.Operation
                            .getOperationByCode(splitString[OPERATION_INDEX]));
            fruitTransaction.setFruit(splitString[FRUIT_TYPE_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(splitString[FRUIT_QUANTITY_INDEX]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }

}
