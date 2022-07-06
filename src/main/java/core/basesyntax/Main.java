package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceTransactionImpl;
import core.basesyntax.strategy.impl.PurchaseTransactionImpl;
import core.basesyntax.strategy.impl.ReturnTransactionImpl;
import core.basesyntax.strategy.impl.SupplyTransactionImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String transactionFilePath = "src/main/resources/transaction.csv";
    private static final String dayReportFilePath = "src/main/resources/dayreport.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE.getOperation(), new BalanceTransactionImpl());
        operationHandlerMap.put(Operation.PURCHASE.getOperation(), new PurchaseTransactionImpl());
        operationHandlerMap.put(Operation.SUPPLY.getOperation(), new SupplyTransactionImpl());
        operationHandlerMap.put(Operation.RETURN.getOperation(), new ReturnTransactionImpl());
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> listOfTransaction = fileReaderService.readFromFile(transactionFilePath);
        TransactionProcessor transactionProcessor
                = new TransactionProcessorImpl(operationHandlerMap);
        transactionProcessor.process(listOfTransaction);
        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        List<String> lines = reportCreatorService.createReport(Storage.getFruitStore());
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(dayReportFilePath, lines);
    }
}
