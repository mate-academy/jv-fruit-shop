package core;

import core.db.Storage;
import core.model.FruitTransaction;
import core.service.DataParserService;
import core.service.ReaderService;
import core.service.ReportSevice;
import core.service.TransactionHandler;
import core.service.WriterService;
import core.service.impl.DataParserServiceImpl;
import core.service.impl.ReaderServiceImpl;
import core.service.impl.ReportSeviceImpl;
import core.service.impl.TransactionHandlerImpl;
import core.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE = "src/main/java/resources/file.csv";
    private static final String REPORT_FILE = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFromFile(INPUT_FILE);
        DataParserService parser = new DataParserServiceImpl();
        List<FruitTransaction> transactions = parser.parseList(dataFromFile);
        TransactionHandler transactionHandler = new TransactionHandlerImpl();
        transactionHandler.handle(transactions);
        ReportSevice reportSevice = new ReportSeviceImpl();
        List<String> report = reportSevice.reportGenerator(Storage.fruits);
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, REPORT_FILE);
    }
}
