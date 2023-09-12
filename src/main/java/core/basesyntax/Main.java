package core.basesyntax;

import database.Storage;
import java.io.File;
import java.util.List;
import java.util.Map;
import service.ReaderService;
import service.TransactionCreatorService;
import service.TransactionService;
import service.WriterService;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionCreatorServiceImpl;
import service.impl.WriterServiceImpl;

public class Main {
    public static void main(String[] args) {
        final ReaderService reader = new ReaderServiceImpl();
        final WriterService writer = new WriterServiceImpl();
        Storage storage = new Storage();
        TransactionCreatorService transactionCreatorService = new TransactionCreatorServiceImpl();
        ReportServiceImpl reportService = new ReportServiceImpl();
        File file = new File("src/main/java/resources/test_file.csv");

        reader.readDataFromFile(file);
        transactionCreatorService.creteTransactionsList(reader.getReadLines());
        List<TransactionService> transactionServiceList = transactionCreatorService
                .getListOfTransactions();
        reportService.createReport(transactionServiceList, storage);
        Map<String,Integer> reportList = storage.getReportList();
        writer.writeReportToFile(reportList);
    }
}
