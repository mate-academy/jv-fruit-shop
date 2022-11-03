package com.basesyntax;

import com.basesyntax.dao.impl.OperationHandlerBalanceImpl;
import com.basesyntax.dao.impl.OperationHandlerPurchaseImpl;
import com.basesyntax.dao.impl.OperationHandlerReturnImpl;
import com.basesyntax.dao.impl.OperationHandlerSupplyImpl;
import com.basesyntax.db.impl.StorageImpl;
import com.basesyntax.enums.Operation;
import com.basesyntax.services.impl.CsvFileReaderImpl;
import com.basesyntax.services.impl.CsvFileWriterImpl;
import com.basesyntax.services.impl.TransactionProcessorImpl;
import com.basesyntax.strategy.impl.StrategyImpl;

public class Main {
    public static void main(String[] args) {
        StrategyImpl strategy = new StrategyImpl();
        strategy.addStrategyType(Operation.BALANCE.getOperation(),
                new OperationHandlerBalanceImpl());
        strategy.addStrategyType(Operation.RETURN.getOperation(),
                new OperationHandlerReturnImpl());
        strategy.addStrategyType(Operation.SUPPLY.getOperation(),
                new OperationHandlerSupplyImpl());
        strategy.addStrategyType(Operation.PURCHASE.getOperation(),
                new OperationHandlerPurchaseImpl());

        CsvFileReaderImpl fileReader = new CsvFileReaderImpl("src/input.csv");
        TransactionProcessorImpl transactionProcessor = new TransactionProcessorImpl();
        transactionProcessor.processingData(fileReader.getAcceptedFileAsList(), strategy);

        CsvFileWriterImpl fileWriter = new CsvFileWriterImpl("src/report.csv");
        fileWriter.createReportFile(new StorageImpl().getStorageAsList());
    }
}
