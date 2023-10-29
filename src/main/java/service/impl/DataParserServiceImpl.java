package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Operation;
import model.Transaction;
import service.DataParserService;

public class DataParserServiceImpl implements DataParserService {
    private static final int ZERO_INDEX = 0;
    private static final int ONE_INDEX = 1;
    private static final int TWO_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<Transaction> getTransactionsList(List<String> readLines) {
        List<Transaction> transactionsList = new ArrayList<>();
        for (String line : readLines) {
            Transaction newTransaction = new Transaction();
            String operationSymbol = line.split(SEPARATOR)[ZERO_INDEX];
            newTransaction.setFruitOperation(Operation.getOperation(operationSymbol));
            newTransaction.setFruit(line.split(SEPARATOR)[ONE_INDEX]);
            newTransaction.setValue(Integer.parseInt(line.split(SEPARATOR)[TWO_INDEX]));
            transactionsList.add(newTransaction);
        }
        return transactionsList;
    }
}
