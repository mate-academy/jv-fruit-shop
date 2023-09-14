package core.basesyntax;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Transaction;
import service.ReaderService;
import service.TransactionCreatorService;
import service.WriterService;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionCreatorServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.Operation;
import strategy.OperationHandler;
import strategy.impl.BalanceHandler;
import strategy.impl.PurchaseHandler;
import strategy.impl.ReturnHandler;
import strategy.impl.SupplyHandler;

public class Main {
    public static void main(String[] args) {
        final ReaderService reader = new ReaderServiceImpl();
        final WriterService writer = new WriterServiceImpl();
        TransactionCreatorService transactionCreatorService = new TransactionCreatorServiceImpl();
        ReportServiceImpl reportService = new ReportServiceImpl();
        File file = new File("src/main/resources/test_file.csv");

        List<String> readLinesList = reader.readFile(file.getPath());
        transactionCreatorService.creteTransactionsList(readLinesList);
        List<Transaction> transactionsList = transactionCreatorService
                .creteTransactionsList(readLinesList);
        reportService.createReport(transactionsList);
        writer.writeReportToFile(reportService.getReportList());
    }

    public static Map<Operation, OperationHandler> getOperationMap() {
        Map<Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(Operation.BALANCE, new BalanceHandler());
        operationMap.put(Operation.SUPPLY, new SupplyHandler());
        operationMap.put(Operation.PURCHASE, new PurchaseHandler());
        operationMap.put(Operation.RETURN, new ReturnHandler());
        return operationMap;
    }
}
