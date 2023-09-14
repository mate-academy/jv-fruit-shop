package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Operation;
import model.Transaction;
import service.ReaderService;
import service.SeparatorService;
import service.TransactionProcessor;
import service.WriterService;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.SeparatorServiceImpl;
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
    public static void main(String[] args) {
        final ReaderService reader = new ReaderServiceImpl();
        final WriterService writer = new WriterServiceImpl();
        final String filePath = "src/main/resources/test_file.csv";
        final String pathToSave = "src/main/resources/report_file.csv";
        ReportServiceImpl reportService = new ReportServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(getOperationMap());
        SeparatorService separatorService = new SeparatorServiceImpl();
        TransactionProcessor transactionProcessor = new TransactionProcessorImpl();

        List<String> readLinesList = reader.readFile(filePath);
        List<Transaction> transactionsList = separatorService
                .getTransactionsList(readLinesList, getOperationMap());
        transactionProcessor.createReport(transactionsList, operationStrategy);
        writer.writeReportToFile(reportService.getReportList(), pathToSave);
    }

    private static Map<Operation, OperationHandler> getOperationMap() {
        Map<model.Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(model.Operation.BALANCE, new BalanceHandler());
        operationMap.put(model.Operation.SUPPLY, new SupplyHandler());
        operationMap.put(model.Operation.PURCHASE, new PurchaseHandler());
        operationMap.put(model.Operation.RETURN, new ReturnHandler());
        return operationMap;
    }
}
