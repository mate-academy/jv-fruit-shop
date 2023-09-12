package core.basesyntax;

import database.Storage;
import service.ReaderService;
import service.WriterService;
import service.impl.ReaderServiceImpl;
import service.impl.WriterServiceImpl;
import service.impl.ReportServiceImpl;
import service.TransactionService;
import service.TransactionCreatorService;
import service.impl.TransactionCreatorServiceImpl;
import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TransactionCreatorService transactionCreatorService = new TransactionCreatorServiceImpl();
        ReportServiceImpl reportService = new ReportServiceImpl();
        ReaderService reader = new ReaderServiceImpl();
        WriterService writer = new WriterServiceImpl();

        File file = new File("src/main/java/resources/test_file.csv");

        reader.readDataFromFile(file);
        transactionCreatorService.creteTransactionsList(reader.getReadLines());
        List<TransactionService> transactionServiceList = transactionCreatorService.getListOfTransactions();
        reportService.createReport(transactionServiceList);
        Map<String,Integer> reportList = Storage.REPORT_LIST;
        writer.writeReportToFile(reportList);
    }
}
