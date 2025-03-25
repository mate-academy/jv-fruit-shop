package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Transaction;
import service.Converter;

public class ConverterImpl implements Converter {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_PARAMETER = 0;
    private static final int FRUIT_PARAMETER = 1;
    private static final int QUANTITY_PARAMETER = 2;

    @Override
    public List<Transaction> convertTransaction(List<String> report) {
        List<Transaction> transactionList = new ArrayList<>();
        for (int i = 1; i < report.size(); i++) {
            Transaction transaction = getFromCsvRow(report.get(i));
            transactionList.add(transaction);
        }
        return transactionList;
    }

    private Transaction getFromCsvRow(String row) {
        String[] fields = row.split(SEPARATOR);
        Transaction transaction = new Transaction();
        transaction.setOperation(Transaction.Operation
                .operationFromCode(fields[OPERATION_PARAMETER]));
        transaction.setFruit(fields[FRUIT_PARAMETER]);
        try {
            transaction.setQuantity(Integer.parseInt(fields[QUANTITY_PARAMETER]));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Cannot define quantity. Invalid number found.");
        }
        return transaction;
    }
}
