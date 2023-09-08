package service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.FruitTransaction;
import model.Transaction;
import service.TransactionConverter;

public class FruitTransactionConverter implements TransactionConverter {
    private List<Transaction> transactionList = new ArrayList<>();

    @Override
    public List<Transaction> convertToTransactionList(List<String[]> dataFromFile) {
        for (int i = 1; i < dataFromFile.size(); i++) {
            String operationCode = dataFromFile.get(i)[0];
            FruitTransaction.Operation operation = Arrays
                    .stream(FruitTransaction.Operation.values())
                    .filter(o -> o.getCode().equals(operationCode))
                    .findFirst()
                    .orElseThrow(() ->
                            new RuntimeException("Incorrect operation code was provided"));
            String fruitName = dataFromFile.get(i)[1];
            int fruitQuantity = Integer.parseInt(dataFromFile.get(i)[2]);
            transactionList.add(new FruitTransaction(operation, fruitName, fruitQuantity));
        }
        return transactionList;
    }
}
