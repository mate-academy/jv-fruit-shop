package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Operation;
import model.Transaction;
import service.SeparatorService;
import strategy.OperationHandler;

public class SeparatorServiceImpl implements SeparatorService {
    private static final int ZERO_INDEX = 0;
    private static final int ONE_INDEX = 1;
    private static final int TWO_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<Transaction> getTransactionsList(List<String> readLines, Map<Operation,
                                                 OperationHandler> operationHandlerMap) {
        List<Transaction> transactionsList = new ArrayList<>();
        for (String line : readLines) {
            Transaction newTransaction = new Transaction();
            String operationSymbol = line.split(SEPARATOR)[ZERO_INDEX];
            newTransaction.setFruitOperation(getOperation(operationHandlerMap, operationSymbol));
            newTransaction.setFruit(line.split(SEPARATOR)[ONE_INDEX]);
            newTransaction.setValue(Integer.parseInt(line.split(SEPARATOR)[TWO_INDEX]));
            transactionsList.add(newTransaction);
        }
        return transactionsList;
    }

    private Operation getOperation(Map<Operation, OperationHandler> operationHandlerMap,
                                          String operationSymbol) {
        for (Operation key :operationHandlerMap.keySet()) {
            if (key.getCode().equals(operationSymbol)) {
                return key;
            }
        }
        throw new RuntimeException("No such operation");
    }
}
