package core.basesyntax.service.operation;

import java.util.ArrayList;
import java.util.List;

public class OperationParserImpl implements OperationParser {
    private static final int OFFSET = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitOperation> getFruitTransaction(List<String> transactionData) {
        List<FruitOperation> fruitTransactionList = new ArrayList<>();
        for (int i = OFFSET; i < transactionData.size(); i++) {
            FruitOperation fruitTransaction = new FruitOperation();
            String[] splitString = transactionData.get(i).split(SEPARATOR);
            fruitTransaction.setOperation(FruitOperation.Operation
                            .getOperationByCode(splitString[OPERATION_INDEX]));
            fruitTransaction.setFruit(splitString[FRUIT_TYPE_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(splitString[FRUIT_QUANTITY_INDEX]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
