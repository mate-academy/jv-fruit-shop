package com.mate.fruitshop.service.impl;

import com.mate.fruitshop.model.Transaction;
import com.mate.fruitshop.service.TransactionReaderService;
import java.util.ArrayList;
import java.util.List;

public class TransactionReaderServiceImpl implements TransactionReaderService {
    @Override
    public List<Transaction> read(List<String> lines) {
        List<Transaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] values = line.split(",");
            Transaction.Operation operation = Transaction.Operation.getOperationByCode(values[0]);
            if (operation == null) {
                continue;
            }
            String fruitName = values[1];
            int quantity = Integer.parseInt(values[2]);
            transactions.add(new Transaction(operation, fruitName, quantity));
        }
        return transactions;
    }
}
