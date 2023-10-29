package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.TransactionConverter;

public class FruitTransactionConverter implements TransactionConverter {
    public static final int OPERATION_CODE_INDEX = 0;
    public static final int FRUIT_NAME_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    private final List<FruitTransaction> transactionList = new ArrayList<>();

    @Override
    public List<FruitTransaction> convertToTransactionList(List<String[]> dataFromFile) {
        for (int i = 1; i < dataFromFile.size(); i++) {
            String operationCode = dataFromFile.get(i)[OPERATION_CODE_INDEX];
            FruitTransaction.Operation operation = FruitTransaction
                    .Operation.getByCode(operationCode);
            String fruitName = dataFromFile.get(i)[FRUIT_NAME_INDEX];
            int fruitQuantity = Integer.parseInt(dataFromFile.get(i)[QUANTITY_INDEX]);
            transactionList.add(new FruitTransaction(operation, fruitName, fruitQuantity));
        }
        return transactionList;
    }
}
