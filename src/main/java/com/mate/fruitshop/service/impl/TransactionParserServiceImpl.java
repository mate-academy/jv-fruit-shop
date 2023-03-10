package com.mate.fruitshop.service.impl;

import com.mate.fruitshop.model.Transaction;
import com.mate.fruitshop.service.TransactionParserService;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserServiceImpl implements TransactionParserService {

    public static final String DELIMITER = ",";
    public static final int OPERATION_CODE_INDEX = 0;
    public static final int FRUIT_NAME_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<Transaction> read(List<String> lines) {
        List<Transaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] values = line.split(DELIMITER);
            Transaction.Operation operation =
                    Transaction.Operation.getOperationByCode(values[OPERATION_CODE_INDEX]);
            if (operation == null) {
                continue;
            }
            String fruitName = values[FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(values[QUANTITY_INDEX]);
            transactions.add(new Transaction(operation, fruitName, quantity));
        }
        return transactions;
    }
}
