package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Transaction;
import service.TransactionMapper;

public class TransactionMapperImpl implements TransactionMapper {
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_NAME_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private static final int COMPONENT_NUMBER = 3;

    @Override
    public List<Transaction> map(List<String> records) {
        List<Transaction> transactions = new ArrayList<>();
        if (records.isEmpty()) {
            throw new RuntimeException("There are no records");
        }
        for (String record : records) {
            Transaction transaction = createTransaction(record);
            transactions.add(transaction);
        }
        return transactions;
    }

    private Transaction createTransaction(String record) {
        String[] recordComponents = record.split(",");
        if (recordComponents.length != COMPONENT_NUMBER) {
            throw new RuntimeException("Invalid record");
        }
        //String operationLabel
        Transaction.Operation operation
                = Transaction.Operation.getFullName(recordComponents[OPERATION_POSITION]);
        String fruitName = recordComponents[FRUIT_NAME_POSITION];
        int quantity = Integer.parseInt(recordComponents[QUANTITY_POSITION]);
        return new Transaction(operation, fruitName, quantity);
    }
}
