package main.service.Impl;

import main.dao.ReportDao;
import main.model.ProductTransaction;
import main.service.TransactionProcessing;
import main.strategy.OperationStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionProcessingImpl implements TransactionProcessing {
    private OperationStrategy operationStrategy;
    private ReportDao reportDao;

    public TransactionProcessingImpl(OperationStrategy operationStrategy, ReportDao reportDao) {
        this.operationStrategy = operationStrategy;
        this.reportDao = reportDao;
    }

    @Override
    public void perform(Map<String, List<ProductTransaction>> transactionMap) {
        Map<String, Integer> transactionResultMap = new HashMap<>();

        for (Map.Entry<String, List<ProductTransaction>> entry: transactionMap.entrySet()) {
            String productName = entry.getKey();
            List<ProductTransaction> productTransactionList = entry.getValue();
            int balance = getBalance(productTransactionList);
            for (ProductTransaction transaction: productTransactionList) {
                balance = operationStrategy
                    .get(transaction.getOperation())
                    .perform(balance, transaction.getQuantity());
            }
            transactionResultMap.put(productName, balance);
        }

        reportDao.set(transactionResultMap);
    }

    private int getBalance(List<ProductTransaction> transactionList) {
        ProductTransaction balanceTransaction = transactionList.stream()
            .filter(productTransaction -> productTransaction.getOperation() == ProductTransaction.Operation.BALANCE)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Can't find BALANCE transaction in this list " + transactionList));

        return balanceTransaction.getQuantity();
    }
}
