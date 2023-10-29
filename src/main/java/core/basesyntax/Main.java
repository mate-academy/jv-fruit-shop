package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Operation;
import model.Transaction;
import service.DataParserService;
import service.ReaderService;
import service.TransactionProcessor;
import service.WriterService;
import service.impl.DataParserServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionProcessorImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.impl.BalanceHandler;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseHandler;
import strategy.impl.ReturnHandler;
import strategy.impl.SupplyHandler;

public class Main {
    private static final String filePath = "src/main/resources/test_file.csv";
    private static final String pathToSave = "src/main/resources/report_file.csv";

    public static void main(String[] args) {
        final ReaderService reader = new ReaderServiceImpl();
        final WriterService writer = new WriterServiceImpl();
        ReportServiceImpl reportService = new ReportServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(getOperationMap());
        DataParserService separatorService = new DataParserServiceImpl();
        TransactionProcessor transactionProcessor = new TransactionProcessorImpl(operationStrategy);

        List<String> readLinesList = reader.readFile(filePath);
        List<Transaction> transactionsList = separatorService
                .getTransactionsList(readLinesList);
        transactionProcessor.processTransaction(transactionsList);
        writer.writeReportToFile(reportService.getReport(), pathToSave);
    }

    private static Map<Operation, OperationHandler> getOperationMap() {
        Map<model.Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(Operation.BALANCE, new BalanceHandler());
        operationMap.put(Operation.SUPPLY, new SupplyHandler());
        operationMap.put(Operation.PURCHASE, new PurchaseHandler());
        operationMap.put(Operation.RETURN, new ReturnHandler());
        return operationMap;
    }
}
