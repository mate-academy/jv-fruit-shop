package core.basesyntax;

import core.basesyntax.operation.BalanceOperationHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperationHandler;
import core.basesyntax.operation.ReturnOperationHandler;
import core.basesyntax.operation.SupplyOperationHandler;
import core.basesyntax.service.FileReaderToolImpl;
import core.basesyntax.service.FileWriterToolImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionExecutorImpl;
import core.basesyntax.service.TransactionsFormerImpl;
import core.basesyntax.service.ReportFormerImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String inputFilePath = "src/main/resources/input.csv";
        final String reportFilePath = "src/main/resources/report.csv";
        FileReaderToolImpl fileReader = new FileReaderToolImpl();
        List<String> data = fileReader.getData(inputFilePath);

        TransactionsFormerImpl transactionsFormerImpl = new TransactionsFormerImpl();
        List<FruitTransaction> transactions = transactionsFormerImpl.formTransactionList(data);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());


        TransactionExecutorImpl executor = new TransactionExecutorImpl(operationHandlerMap);
        for (FruitTransaction transaction : transactions) {
            executor.transactionExecute(transaction);
        }

        ReportFormerImpl reportFormer = new ReportFormerImpl();
        String report = reportFormer.formReport();

        FileWriterToolImpl fileWriter = new FileWriterToolImpl();
        fileWriter.writeReport(report, reportFilePath);
    }
}
