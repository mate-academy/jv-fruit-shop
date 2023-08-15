package core.basesyntax.service.transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int BEGINNING_OF_THE_LIST = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getFruitTransaction(List<String> dataFromReport) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = BEGINNING_OF_THE_LIST; i < dataFromReport.size(); i++) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] splitString = dataFromReport.get(i).split(",");
            fruitTransaction.setOperation(FruitTransaction.Operation
                            .getOperationByString(splitString[OPERATION_INDEX]));
            fruitTransaction.setFruit(splitString[FRUIT_TYPE_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(splitString[FRUIT_QUANTITY_INDEX]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }

}
