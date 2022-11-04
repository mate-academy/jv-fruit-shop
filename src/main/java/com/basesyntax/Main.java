package com.basesyntax;

import com.basesyntax.db.impl.StorageImpl;
import com.basesyntax.enums.Operation;
import com.basesyntax.services.impl.CsvFileReaderImpl;
import com.basesyntax.services.impl.CsvFileWriterImpl;
import com.basesyntax.services.impl.TransactionProcessorImpl;
import com.basesyntax.strategy.impl.OperationHandlerBalanceImpl;
import com.basesyntax.strategy.impl.OperationHandlerPurchaseImpl;
import com.basesyntax.strategy.impl.OperationHandlerReturnImpl;
import com.basesyntax.strategy.impl.OperationHandlerSupplyImpl;
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

        CsvFileReaderImpl fileReader = new CsvFileReaderImpl();
        TransactionProcessorImpl transactionProcessor = new TransactionProcessorImpl();
        transactionProcessor.processingData(fileReader
                .getAcceptedFileAsList("src/source/input.csv"), strategy);

        CsvFileWriterImpl fileWriter = new CsvFileWriterImpl();
        fileWriter.createReportFile("src/report.csv", new StorageImpl().getStorageAsList());
    }
}
