package core.basesyntax.service.operation;

import java.util.ArrayList;
import java.util.List;

public class OperationParserImpl implements OperationParser {
    private static final int BEGINNING_OF_THE_LIST = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;
    private static final String COMMA = ",";

    @Override
    public List<FruitOperation> getFruitTransaction(List<String> transactionData) {
        List<FruitOperation> fruitTransactionList = new ArrayList<>();
        for (int i = BEGINNING_OF_THE_LIST; i < transactionData.size(); i++) {
            FruitOperation fruitTransaction = new FruitOperation();
            String[] splitString = transactionData.get(i).split(COMMA);
            fruitTransaction.setOperation(FruitOperation.Operation
                            .getOperationByCode(splitString[OPERATION_INDEX]));
            fruitTransaction.setFruit(splitString[FRUIT_TYPE_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(splitString[FRUIT_QUANTITY_INDEX]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
